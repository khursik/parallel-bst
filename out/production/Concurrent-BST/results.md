# Parallel BST algorithm performance results

## Results
### x = 0.5
#### 1048576 keys
input: **1 thread**, 1048576keys (1MB), x = 0.5 (30% inserts, 30% contains and 30% removes)
```text
BST-1thr-1048576keys-30i-30d
1 experiments in total
initnodes-508427-in1.5s[7reps]-BST-1thr-1048576keys-30i-30d | trial 0 : 20.0% done, elapsed 7s
initnodes-506868-in1.2s[7reps]-BST-1thr-1048576keys-30i-30d | trial 1 : 40.0% done, elapsed 13s
initnodes-507128-in1.2s[7reps]-BST-1thr-1048576keys-30i-30d | trial 2 : 60.0% done, elapsed 19s
initnodes-507415-in1.2s[7reps]-BST-1thr-1048576keys-30i-30d | trial 3 : 80.0% done, elapsed 26s
initnodes-507432-in1.2s[7reps]-BST-1thr-1048576keys-30i-30d | trial 4 : 100.0% done, elapsed 32s
```
input: **2 threads**, 1048576keys (1MB), x = 0.5 (30% inserts, 30% contains and 30% removes)
```text
BST-2thr-1048576keys-30i-30d
1 experiments in total
initnodes-508395-in1.3s[7reps]-BST-2thr-1048576keys-30i-30d | trial 0 : 20.0% done, elapsed 6s
initnodes-507029-in1.2s[7reps]-BST-2thr-1048576keys-30i-30d | trial 1 : 40.0% done, elapsed 13s
initnodes-507729-in1.2s[7reps]-BST-2thr-1048576keys-30i-30d | trial 2 : 60.0% done, elapsed 19s
initnodes-507914-in1.3s[7reps]-BST-2thr-1048576keys-30i-30d | trial 3 : 80.0% done, elapsed 26s
initnodes-507588-in1.2s[7reps]-BST-2thr-1048576keys-30i-30d | trial 4 : 100.0% done, elapsed 32s
```
input: **3 threads**, 1048576keys (1MB), x = 0.5 (30% inserts, 30% contains and 30% removes)
```text
BST-3thr-1048576keys-30i-30d
1 experiments in total
initnodes-508705-in1.4s[7reps]-BST-3thr-1048576keys-30i-30d | trial 0 : 20.0% done, elapsed 7s
initnodes-507916-in1.2s[7reps]-BST-3thr-1048576keys-30i-30d | trial 1 : 40.0% done, elapsed 13s
initnodes-507671-in1.3s[7reps]-BST-3thr-1048576keys-30i-30d | trial 2 : 60.0% done, elapsed 20s
initnodes-508150-in1.4s[7reps]-BST-3thr-1048576keys-30i-30d | trial 3 : 80.0% done, elapsed 26s
initnodes-507517-in1.5s[7reps]-BST-3thr-1048576keys-30i-30d | trial 4 : 100.0% done, elapsed 33s
```
input: **4 threads**, 1048576keys (1MB), x = 0.5 (30% inserts, 30% contains and 30% removes)
```text
BST-4thr-1048576keys-30i-30d
1 experiments in total
initnodes-508426-in1.3s[7reps]-BST-4thr-1048576keys-30i-30d | trial 0 : 20.0% done, elapsed 6s
initnodes-507847-in1.2s[7reps]-BST-4thr-1048576keys-30i-30d | trial 1 : 40.0% done, elapsed 13s
initnodes-506195-in0.9s[7reps]-BST-4thr-1048576keys-30i-30d | trial 2 : 60.0% done, elapsed 19s
initnodes-507022-in1.3s[7reps]-BST-4thr-1048576keys-30i-30d | trial 3 : 80.0% done, elapsed 25s
initnodes-506651-in1.3s[7reps]-BST-4thr-1048576keys-30i-30d | trial 4 : 100.0% done, elapsed 32s
```
#### 100000 keys
input: **1 thread**, 100000 keys, x = 0.5 (30% inserts, 30% contains and 30% removes)
```text
BST-1thr-100000keys-30i-30d
1 experiments in total
initnodes-48419-in170.8ms[8reps]-BST-1thr-100000keys-30i-30d XXXXXXXXX trial 0 : 20.0% done, elapsed 5s
initnodes-48052-in80.2ms[7reps]-BST-1thr-100000keys-30i-30d XXXXXXXXX trial 1 : 40.0% done, elapsed 10s
initnodes-47978-in75.2ms[7reps]-BST-1thr-100000keys-30i-30d XXXXXXXXX trial 2 : 60.0% done, elapsed 15s
initnodes-48362-in73.2ms[7reps]-BST-1thr-100000keys-30i-30d XXXXXXXXX trial 3 : 80.0% done, elapsed 21s
initnodes-48202-in77.7ms[7reps]-BST-1thr-100000keys-30i-30d XXXXXXXXX trial 4 : 100.0% done, elapsed 26s
```
input: **2 threads**, 100000 keys, x = 0.5 (30% inserts, 30% contains and 30% removes)
```text
BST-2thr-100000keys-30i-30d
1 experiments in total
initnodes-48546-in202.0ms[8reps]-BST-2thr-100000keys-30i-30d | trial 0 : 20.0% done, elapsed 5s
initnodes-48180-in71.7ms[7reps]-BST-2thr-100000keys-30i-30d | trial 1 : 40.0% done, elapsed 10s
initnodes-48125-in91.5ms[7reps]-BST-2thr-100000keys-30i-30d | trial 2 : 60.0% done, elapsed 15s
initnodes-47523-in60.8ms[6reps]-BST-2thr-100000keys-30i-30d | trial 3 : 80.0% done, elapsed 21s
initnodes-48066-in86.9ms[7reps]-BST-2thr-100000keys-30i-30d | trial 4 : 100.0% done, elapsed 26s
```
input: **3 threads**, 100000 keys, x = 0.5 (30% inserts, 30% contains and 30% removes)
```text
BST-3thr-100000keys-30i-30d
1 experiments in total
initnodes-47770-in127.4ms[7reps]-BST-3thr-100000keys-30i-30d | trial 0 : 20.0% done, elapsed 5s
initnodes-48179-in93.4ms[7reps]-BST-3thr-100000keys-30i-30d | trial 1 : 40.0% done, elapsed 10s
initnodes-48264-in72.5ms[7reps]-BST-3thr-100000keys-30i-30d | trial 2 : 60.0% done, elapsed 15s
initnodes-48498-in66.7ms[7reps]-BST-3thr-100000keys-30i-30d | trial 3 : 80.0% done, elapsed 21s
initnodes-48095-in72.0ms[7reps]-BST-3thr-100000keys-30i-30d | trial 4 : 100.0% done, elapsed 26s
```
input: **4 threads**, 100000 keys, x = 0.5 (30% inserts, 30% contains and 30% removes)
```text
BST-4thr-100000keys-30i-30d
1 experiments in total
initnodes-47926-in131.0ms[7reps]-BST-4thr-100000keys-30i-30d XXXXXXXXX trial 0 : 20.0% done, elapsed 5s
initnodes-48244-in67.7ms[7reps]-BST-4thr-100000keys-30i-30d XXXXXXXXX trial 1 : 40.0% done, elapsed 10s
initnodes-48264-in59.2ms[7reps]-BST-4thr-100000keys-30i-30d XXXXXXXXX trial 2 : 60.0% done, elapsed 15s
initnodes-48180-in69.7ms[7reps]-BST-4thr-100000keys-30i-30d XXXXXXXXX trial 3 : 80.0% done, elapsed 21s
initnodes-48000-in67.5ms[7reps]-BST-4thr-100000keys-30i-30d XXXXXXXXX trial 4 : 100.0% done, elapsed 26s
```
### 10^4 keys
```text
BST-1thr-100000keys-10i-0d
1 experiments in total
initnodes-96130-in585.3ms[9reps]-BST-1thr-100000keys-10i-0d  |  trial 0 : 20.0% done, elapsed 6s
initnodes-95608-in146.3ms[7reps]-BST-1thr-100000keys-10i-0d  |  trial 1 : 40.0% done, elapsed 11s
initnodes-95383-in140.6ms[7reps]-BST-1thr-100000keys-10i-0d  |  trial 2 : 60.0% done, elapsed 16s
initnodes-96379-in127.3ms[7reps]-BST-1thr-100000keys-10i-0d  |  trial 3 : 80.0% done, elapsed 21s
initnodes-96104-in136.6ms[7reps]-BST-1thr-100000keys-10i-0d  |  trial 4 : 100.0% done, elapsed 26s
```





