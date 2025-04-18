# 操作系统实验项目

本项目包含两个操作系统核心实验：**动态分区管理** 和 **磁盘调度算法**，旨在帮助理解内存管理与磁盘调度策略的实现方式和性能差异。

---

## 📂 实验目录  

- [实验 1：动态分区管理](https://github.com/zzzy-code/operationSystem_whut/tree/main/operationSystem_1) 
- [实验 2：磁盘调度](https://github.com/zzzy-code/operationSystem_whut/tree/main/operationSystem_2)  

---

## 📝 实验 1：动态分区管理  

### 📖 实验描述  
模拟动态分区内存管理，主要实现以下功能：
- 根据进程的需求分配和释放内存  
- 支持不同分区分配策略  
- 追踪内存使用情况，计算外部碎片  

### 📌 实验功能  

- **动态分区分配与回收**  
- **三种分区分配策略**：
  - 📌 首次适应（First-Fit）  
  - 📌 最佳适应（Best-Fit）  
  - 📌 最坏适应（Worst-Fit）  
- **内存使用跟踪**：
  - 记录进程内存占用情况  
  - 统计外部碎片数量和大小  

---

## 📝 实验 2：磁盘调度  

### 📖 实验描述  
模拟多种磁盘调度算法，提升磁盘读写调度效率，减少磁头移动时间。

### 📌 实验功能  

- **多种磁盘调度算法实现**：
  - 📌 先来先服务（FCFS - First-Come, First-Served）  
  - 📌 最短寻道时间优先（SSTF - Shortest Seek Time First）  
  - 📌 扫描算法（SCAN - 电梯算法）  
- **磁盘臂运动模拟**
  - 计算磁头移动路径  
  - 对比评估不同调度算法的性能  

---

## 🚀 运行方式  

1. **克隆项目仓库**

```bash
git clone https://github.com/your-username/operation-system-experiments.git
```

2. **进入项目目录**

```bash
cd operation-system-experiments
```

3. **根据目录说明，运行相应实验程序**

---

## 📌 项目说明  

- 本项目为操作系统课程实验项目，代码均配有详细注释，便于理解学习。  
- 可在不同分区策略与调度算法下测试多组数据，观察性能对比效果。

---
