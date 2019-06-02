# MapReduce
MapReduce parctice.

---

## WordCount
A counter to count differernt word and its number.

### How to run?
- Set classpath according to [reference document][1]
- Compile them
  ``` shell
  javac *.java
  ```
- Pack them into a jar
  ``` shell
  jar cvf WordCount.jar *.class
  ```
- Upload input file to HDFS
  ``` shell
  hadoop fs -mkdir -p /input/WordCount
  hadoop fs -put input_file.txt /input/WordCount
  ```
- Create a output path(If already exists, skip to next step)
  ``` shell
  hadoop fs -mkdir /output
  ```
- Run it
  ``` shell
  hadoop jar WordCount.jar WordCount /input/WordCount /output/WordCount
  ```
- Cat or download output file
  ``` shell
  hadoop fs -cat /output/WordCount/part-r-00000
  hadoop fs -get /output/WordCount/part-r-00000 result.txt
  ```

---

## MeanScore
Calculate mean score from student transcript by studnet and by subject

### StudentMean
#### How to run?
- Set classpath according to [reference document][1]
- Compile them
  ``` shell
  javac StudentMean\*.java
  ```
- Pack them into a jar
  ``` shell
  jar cvf StudentMean.jar StudentMean\*.class
  ```
- Upload input file to HDFS
  ``` shell
  hadoop fs -mkdir -p /input/ScoreMean
  hadoop fs -put student_transcript.txt /input/ScoreMean
  ```
- Create a output path(If already exists, skip to next step)
  ``` shell
  hadoop fs -mkdir /output
  ```
- Run it
  ``` shell
  hadoop jar StudentMean.jar StudentMean.StudentMean /input/ScoreMean /output/StudentMean
  ```
- Cat or download output file
  ``` shell
  hadoop fs -cat /output/StudentMean/part-r-00000
  hadoop fs -get /output/StudentMean/part-r-00000 StudentMean.txt
  ```

### SubjectMean
#### How to run?
- Set classpath according to [reference document][1]
- Compile them
  ``` shell
  javac SubjectMean\*.java
  ```
- Pack them into a jar
  ``` shell
  jar cvf SubjectMean.jar SubjectMean\*.class
  ```
- Upload input file to HDFS(If already exists, skip to next step)
  ``` shell
  hadoop fs -mkdir -p /input/ScoreMean
  hadoop fs -put student_transcript.txt /input/ScoreMean
  ```
- Create a output path(If already exists, skip to next step)
  ``` shell
  hadoop fs -mkdir /output
  ```
- Run it
  ``` shell
  hadoop jar SubjectMean.jar SubjectMean.SubjectMean /input/ScoreMean /output/SubjectMean
  ```
- Cat or download output file
  ``` shell
  hadoop fs -cat /output/SubjectMean/part-r-00000
  hadoop fs -get /output/SubjectMean/part-r-00000 SubjectMean.txt
  ```

## GrandchildGrandparent
Input a child-parent file, find all grandchild-grandparent. Suppose there is no same name

### How to run?
- Set classpath according to [reference document][1]
- Compile them
  ``` shell
  javac *.java
  ```
- Pack them into a jar
  ``` shell
  jar cvf GrandchildGrandparent.jar *.class
  ```
- Upload input file to HDFS
  ``` shell
  hadoop fs -mkdir -p /input/GrandchildGrandparent
  hadoop fs -put child-parent.txt /input/GrandchildGrandparent
  ```
- Create a output path(If already exists, skip to next step)
  ``` shell
  hadoop fs -mkdir /output
  ```
- Run it
  ``` shell
  hadoop jar SubjectMean.jar SubjectMean.SubjectMean /input/ScoreMean /output/SubjectMean
  ```
- Cat or download output file
  ``` shell
  hadoop fs -cat /output/GrandchildGrandparent/part-r-00000
  hadoop fs -get /output/GrandchildGrandparent/part-r-00000 GrandchildGrandparent.txt
  ```

[1]: https://github.com/LittleGreenMouse/HDFSTest/blob/master/Install_hadoop_on_win10.md#set-classpath-for-java-program