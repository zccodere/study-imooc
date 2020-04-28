package com.myimooc.thread.daemon;

/**
 * Java stack
 *
 * @author ZhangCheng on 2017-07-08
 */
public class Jstack {
/*

2017-07-08 23:49:46
Full thread dump Java HotSpot(TM) 64-Bit Server VM (25.101-b13 mixed mode):

"Thread-0" #10 daemon prio=5 os_prio=0 tid=0x000000001d209800 nid=0x2e00 waiting on condition [0x000000001dd2f000]
   java.lang.Thread.State: TIMED_WAITING (sleeping)
        at java.lang.Thread.sleep(Native Method)
        at DaemonThread.writeToFile(DaemonThread.java:39)
        at DaemonThread.run(DaemonThread.java:19)
        at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
        - None

"Service Thread" #9 daemon prio=9 os_prio=0 tid=0x000000001d1b9800 nid=0x2480 runnable [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
        - None

"C1 CompilerThread2" #8 daemon prio=9 os_prio=2 tid=0x000000001d13b000 nid=0x2078 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
        - None

"C2 CompilerThread1" #7 daemon prio=9 os_prio=2 tid=0x000000001be2d800 nid=0x24f4 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
        - None

"C2 CompilerThread0" #6 daemon prio=9 os_prio=2 tid=0x000000001bddf000 nid=0x2f64 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
        - None

"Attach Listener" #5 daemon prio=5 os_prio=2 tid=0x000000001bdde000 nid=0x1c1c waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
        - None

"Signal Dispatcher" #4 daemon prio=9 os_prio=2 tid=0x000000001bdc8800 nid=0x247c runnable [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
        - None

"Finalizer" #3 daemon prio=8 os_prio=1 tid=0x000000001bdba800 nid=0x1f10 in Object.wait() [0x000000001d12f000]
   java.lang.Thread.State: WAITING (on object monitor)
        at java.lang.Object.wait(Native Method)
        - waiting on <0x000000076b108ee0> (a java.lang.ref.ReferenceQueue$Lock)
        at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:143)
        - locked <0x000000076b108ee0> (a java.lang.ref.ReferenceQueue$Lock)
        at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:164)
        at java.lang.ref.Finalizer$FinalizerThread.run(Finalizer.java:209)

   Locked ownable synchronizers:
        - None

"Reference Handler" #2 daemon prio=10 os_prio=2 tid=0x00000000027a2800 nid=0x2214 in Object.wait() [0x000000001d02f000]
   java.lang.Thread.State: WAITING (on object monitor)
        at java.lang.Object.wait(Native Method)
        - waiting on <0x000000076b106b50> (a java.lang.ref.Reference$Lock)
        at java.lang.Object.wait(Object.java:502)
        at java.lang.ref.Reference.tryHandlePending(Reference.java:191)
        - locked <0x000000076b106b50> (a java.lang.ref.Reference$Lock)
        at java.lang.ref.Reference$ReferenceHandler.run(Reference.java:153)

   Locked ownable synchronizers:
        - None

"main" #1 prio=5 os_prio=0 tid=0x000000000099d800 nid=0xf2c runnable [0x000000000228e000]
   java.lang.Thread.State: RUNNABLE
        at java.io.FileInputStream.readBytes(Native Method)
        at java.io.FileInputStream.read(FileInputStream.java:255)
        at java.io.BufferedInputStream.read1(BufferedInputStream.java:284)
        at java.io.BufferedInputStream.read(BufferedInputStream.java:345)
        - locked <0x000000076b159560> (a java.io.BufferedInputStream)
        at sun.nio.cs.StreamDecoder.readBytes(StreamDecoder.java:284)
        at sun.nio.cs.StreamDecoder.implRead(StreamDecoder.java:326)
        at sun.nio.cs.StreamDecoder.read(StreamDecoder.java:178)
        - locked <0x000000076b1b9ce8> (a java.io.InputStreamReader)
        at java.io.InputStreamReader.read(InputStreamReader.java:184)
        at java.io.Reader.read(Reader.java:100)
        at java.util.Scanner.readInput(Scanner.java:804)
        at java.util.Scanner.next(Scanner.java:1369)
        at DaemonThreadDemo.main(DaemonThreadDemo.java:22)

   Locked ownable synchronizers:
        - None

"VM Thread" os_prio=2 tid=0x000000001bd98000 nid=0x2998 runnable

"GC task thread#0 (ParallelGC)" os_prio=0 tid=0x00000000026c6800 nid=0x11b0 runnable

"GC task thread#1 (ParallelGC)" os_prio=0 tid=0x00000000026c8000 nid=0x26a4 runnable

"GC task thread#2 (ParallelGC)" os_prio=0 tid=0x00000000026c9800 nid=0x2d6c runnable

"GC task thread#3 (ParallelGC)" os_prio=0 tid=0x00000000026cb000 nid=0xab0 runnable

"VM Periodic Task Thread" os_prio=2 tid=0x000000001d1f3000 nid=0x2b08 waiting on condition

JNI global references: 6

*/
}
