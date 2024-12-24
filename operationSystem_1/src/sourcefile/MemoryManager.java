package sourcefile;

import java.util.ArrayList;
import java.util.List;

public class MemoryManager {
    private List<MemoryBlock> memoryBlocks; // 动态分区链表
    private int totalSize;                 // 内存总大小
    private int processCounter = 1;        // 进程编号计数器

    public MemoryManager(int totalSize) {
        this.totalSize = totalSize;
        memoryBlocks = new ArrayList<>();
        memoryBlocks.add(new MemoryBlock(0, totalSize, true, -1)); // 初始化为一个空闲块
    }

    // 显示当前内存状态
    public void showMemory() {
        System.out.println("=====================================");
        System.out.println("起始地址\t大小\t状态\t进程号");
        for (MemoryBlock block : memoryBlocks) {
            String status = block.isFree ? "空闲" : "占用";
            System.out.println(block.startAddress + "\t\t" + block.size + "\t" + status + "\t" + (block.isFree ? "-" : block.processId));
        }
    }

    // 分配内存
    public void allocate(int processSize, int algorithm) {
        int index = -1;

        switch (algorithm) {
            case 1: // 最先适应法
                index = findFirstFit(processSize);
                break;
            case 2: // 最佳适应法
                index = findBestFit(processSize);
                break;
            case 3: // 最坏适应法
                index = findWorstFit(processSize);
                break;
            default:
                System.out.println("无效的算法选择！");
                return;
        }

        if (index == -1) {
            System.out.println("分配失败：没有足够的内存！");
            return;
        }

        MemoryBlock block = memoryBlocks.get(index);
        if (block.size > processSize) {
            // 分割内存块
            MemoryBlock newBlock = new MemoryBlock(block.startAddress + processSize, block.size - processSize, true, -1);
            memoryBlocks.add(index + 1, newBlock);
        }

        // 更新分配的块
        block.size = processSize;
        block.isFree = false;
        block.processId = processCounter++;
        System.out.println("内存分配成功！进程号：" + block.processId);
    }

    // 回收内存
    public void free(int processId) {
        boolean found = false;

        for (int i = 0; i < memoryBlocks.size(); i++) {
            MemoryBlock block = memoryBlocks.get(i);
            if (!block.isFree && block.processId == processId) {
                found = true;
                block.isFree = true;
                block.processId = -1;

                // 合并相邻空闲块
                if (i > 0 && memoryBlocks.get(i - 1).isFree) {
                    MemoryBlock previous = memoryBlocks.get(i - 1);
                    previous.size += block.size;
                    previous.processId = -1;
                    memoryBlocks.remove(i);
                    i--; // 更新索引
                }

                if (i < memoryBlocks.size() - 1 && memoryBlocks.get(i + 1).isFree) {
                    MemoryBlock next = memoryBlocks.get(i + 1);
                    block.size += next.size;
                    memoryBlocks.remove(i + 1);
                }

                System.out.println("进程 " + processId + " 的内存回收成功！");
                break;
            }
        }

        if (!found) {
            System.out.println("内存回收失败：未找到进程 " + processId);
        }

        // 检查是否所有内存块被回收
        if (memoryBlocks.size() == 1 && memoryBlocks.get(0).isFree) {
            MemoryBlock singleBlock = memoryBlocks.get(0);
            if (singleBlock.startAddress == 0 && singleBlock.size != totalSize) {
                singleBlock.size = totalSize;
                System.out.println("所有进程内存已回收，内存重置为初始状态。");
            }
        }
    }


    // 最先适应算法
    private int findFirstFit(int processSize) {
        for (int i = 0; i < memoryBlocks.size(); i++) {
            if (memoryBlocks.get(i).isFree && memoryBlocks.get(i).size >= processSize) {
                return i;
            }
        }
        return -1;
    }

    // 最佳适应算法
    private int findBestFit(int processSize) {
        int bestIndex = -1;
        int smallestFit = Integer.MAX_VALUE;

        for (int i = 0; i < memoryBlocks.size(); i++) {
            MemoryBlock block = memoryBlocks.get(i);
            if (block.isFree && block.size >= processSize && block.size < smallestFit) {
                bestIndex = i;
                smallestFit = block.size;
            }
        }

        return bestIndex;
    }

    // 最坏适应算法
    private int findWorstFit(int processSize) {
        int worstIndex = -1;
        int largestFit = -1;

        for (int i = 0; i < memoryBlocks.size(); i++) {
            MemoryBlock block = memoryBlocks.get(i);
            if (block.isFree && block.size >= processSize && block.size > largestFit) {
                worstIndex = i;
                largestFit = block.size;
            }
        }

        return worstIndex;
    }
}
