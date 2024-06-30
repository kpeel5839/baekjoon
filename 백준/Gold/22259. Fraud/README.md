# [Gold III] Fraud - 22259 

[문제 링크](https://www.acmicpc.net/problem/22259) 

### 성능 요약

메모리: 4364 KB, 시간: 60 ms

### 분류

구현, 수학

### 제출 일자

2024년 6월 30일 20:42:48

### 문제 설명

<p>You have been put in charge of the 24th National Olympiad in Informatics!</p>

<p>This year, the competition consisted of N contestants and 2 rounds. The i<sup>th</sup> contestant scored A<sub>i</sub> points in the first round and B<sub>i</sub> points in the second round.</p>

<p>Furthermore, the rounds have associated <strong>positive integer</strong> weightages X and Y respectively. The i<sup>th</sup> contestant’s final score Si is given by S<sub>i</sub> = A<sub>i</sub> × X + B<sub>i</sub> × Y.</p>

<p>As the chairman, you have been given the freedom to select the values of X and Y as you wish.</p>

<p>Alas, Squeaky the Mouse has bribed you into committing fraud. To be exact, he has promised to reward you handsomely if you select some X and Y such that S<sub>i</sub> > S<sub>j</sub> for all 1 ≤ i < j ≤ N.</p>

<p>But is it even possible to do so?</p>

### 입력 

 <p>Your program must read from standard input.</p>

<p>The first line contains a single integer N, the number of contestants.</p>

<p>The second line contains N space-separated integers, A<sub>1</sub>, . . . , A<sub>N</sub>.</p>

<p>The third line contains N space-separated integers, B<sub>1</sub>, . . . , B<sub>N</sub>.</p>

### 출력 

 <p>Your program must print to standard output.</p>

<p>Output <code>YES</code> if it is possible to commit fraud and <code>NO</code> otherwise.</p>

