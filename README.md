# quarkus-reactive-reproducer-context-not-flagged

Reproducer for this Quarkus / Vert.X issue

````
    ERROR: SRMSG00200: The method com.example.EntityAService#onUserRegistrationConfirmed has thrown an exception
    java.lang.IllegalStateException: Hibernate Reactive Panache requires a safe (isolated) Vert.x sub-context, but the current context hasn't been flagged as such.
        at io.quarkus.vertx.core.runtime.context.VertxContextSafetyToggle.checkIsSafe(VertxContextSafetyToggle.java:89)
        at io.quarkus.vertx.core.runtime.context.VertxContextSafetyToggle.validateContextIfExists(VertxContextSafetyToggle.java:72)
        at io.quarkus.hibernate.reactive.panache.common.runtime.SessionOperations.vertxContext(SessionOperations.java:183)
        at io.quarkus.hibernate.reactive.panache.common.runtime.SessionOperations.withSession(SessionOperations.java:112)
        at io.quarkus.hibernate.reactive.panache.common.runtime.WithSessionInterceptor.intercept(WithSessionInterceptor.java:20)
        at io.quarkus.hibernate.reactive.panache.common.runtime.WithSessionInterceptor_Bean.intercept(Unknown Source)
        at io.quarkus.arc.impl.InterceptorInvocation.invoke(InterceptorInvocation.java:42)
        at io.quarkus.arc.impl.AroundInvokeInvocationContext.perform(AroundInvokeInvocationContext.java:30)
        at io.quarkus.arc.impl.InvocationContexts.performAroundInvoke(InvocationContexts.java:27)
        at com.example.EntityAService_Subclass.onUserRegistrationConfirmed(Unknown Source)
        at com.example.EntityAService_ClientProxy.onUserRegistrationConfirmed(Unknown Source)
        at com.example.EntityAService_SmallRyeMessagingInvoker_onUserRegistrationConfirmed_3712669874522feb4afaa8774dd5fa51e4e2f384.invoke(Unknown Source)
        at io.smallrye.reactive.messaging.providers.AbstractMediator.invoke(AbstractMediator.java:136)
        at io.smallrye.reactive.messaging.providers.AbstractMediator.lambda$invokeOnMessageContext$8(AbstractMediator.java:144)
        at io.smallrye.reactive.messaging.providers.locals.LocalContextMetadata.lambda$invokeOnMessageContext$0(LocalContextMetadata.java:34)
        at io.smallrye.reactive.messaging.providers.locals.LocalContextMetadata.lambda$invokeOnMessageContext$1(LocalContextMetadata.java:53)
        at io.smallrye.reactive.messaging.providers.helpers.VertxContext.lambda$runOnContext$0(VertxContext.java:26)
        at io.vertx.core.impl.ContextInternal.dispatch(ContextInternal.java:264)
        at io.vertx.core.impl.ContextInternal.dispatch(ContextInternal.java:246)
        at io.vertx.core.impl.EventLoopContext.lambda$runOnContext$0(EventLoopContext.java:43)
        at io.netty.util.concurrent.AbstractEventExecutor.runTask(AbstractEventExecutor.java:174)
        at io.netty.util.concurrent.AbstractEventExecutor.safeExecute(AbstractEventExecutor.java:167)
        at io.netty.util.concurrent.SingleThreadEventExecutor.runAllTasks(SingleThreadEventExecutor.java:470)
        at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:569)
        at io.netty.util.concurrent.SingleThreadEventExecutor$4.run(SingleThreadEventExecutor.java:997)
        at io.netty.util.internal.ThreadExecutorMap$2.run(ThreadExecutorMap.java:74)
        at io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30)
        at java.base/java.lang.Thread.run(Thread.java:1589)

````
