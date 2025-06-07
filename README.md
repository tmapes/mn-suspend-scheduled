# mn-coroutine-scheduling

Example for this Git [issue](https://github.com/micronaut-projects/micronaut-core/issues/7224)

<details>

<summary>Example stack trace when a 'suspend' '@Scheduled' function tries to run</summary>

```
20:14:10.706 [scheduled-executor-thread-1] ERROR i.m.s.DefaultTaskExceptionHandler - Error creating scheduled task for bean [CoroutineScheduledTask] Argument [Continuation<Unit T> continuation] not satisfied: Unresolvable bean argument: Continuation<Unit T> continuation
io.micronaut.core.bind.exceptions.UnsatisfiedArgumentException: Argument [Continuation<Unit T> continuation] not satisfied: Unresolvable bean argument: Continuation<Unit T> continuation
	at io.micronaut.context.bind.DefaultExecutableBeanContextBinder.lambda$bind$2(DefaultExecutableBeanContextBinder.java:106)
	at java.base/java.util.Optional.orElseThrow(Optional.java:403)
	at io.micronaut.context.bind.DefaultExecutableBeanContextBinder.bind(DefaultExecutableBeanContextBinder.java:105)
	at io.micronaut.scheduling.processor.ScheduledMethodProcessor.lambda$scheduleTask$2(ScheduledMethodProcessor.java:151)
	at java.base/java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:572)
	at java.base/java.util.concurrent.FutureTask.runAndReset(FutureTask.java:358)
	at java.base/java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask.run(ScheduledThreadPoolExecutor.java:305)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1144)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:642)
	at java.base/java.lang.Thread.run(Thread.java:1583)
```

</details>