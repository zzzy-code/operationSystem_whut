package sourcefile;

class MemoryBlock {
    int startAddress;  // 起始地址
    int size;          // 分区大小
    boolean isFree;    // 是否空闲
    int processId;  // 进程号（空闲时为"-"）

    public MemoryBlock(int startAddress, int size, boolean isFree, int processId) {
        this.startAddress = startAddress;
        this.size = size;
        this.isFree = isFree;
        this.processId = processId;
    }
}
