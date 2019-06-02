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


[1]: https://github.com/LittleGreenMouse/HDFSTest/blob/master/Install_hadoop_on_win10.md#set-classpath-for-java-program