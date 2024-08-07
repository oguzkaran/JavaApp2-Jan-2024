package org.csystem.generator.random.text;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.45.1)",
    comments = "Source: randomtextgenerator.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RandomTextGeneratorServiceGrpc {

  private RandomTextGeneratorServiceGrpc() {}

  public static final String SERVICE_NAME = "org.csystem.generator.random.text.RandomTextGeneratorService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.csystem.generator.random.text.RandomTextGeneratorRequest,
      org.csystem.generator.random.text.RandomTextGeneratorResponse> getGenerateRandomTextENMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateRandomTextEN",
      requestType = org.csystem.generator.random.text.RandomTextGeneratorRequest.class,
      responseType = org.csystem.generator.random.text.RandomTextGeneratorResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.csystem.generator.random.text.RandomTextGeneratorRequest,
      org.csystem.generator.random.text.RandomTextGeneratorResponse> getGenerateRandomTextENMethod() {
    io.grpc.MethodDescriptor<org.csystem.generator.random.text.RandomTextGeneratorRequest, org.csystem.generator.random.text.RandomTextGeneratorResponse> getGenerateRandomTextENMethod;
    if ((getGenerateRandomTextENMethod = RandomTextGeneratorServiceGrpc.getGenerateRandomTextENMethod) == null) {
      synchronized (RandomTextGeneratorServiceGrpc.class) {
        if ((getGenerateRandomTextENMethod = RandomTextGeneratorServiceGrpc.getGenerateRandomTextENMethod) == null) {
          RandomTextGeneratorServiceGrpc.getGenerateRandomTextENMethod = getGenerateRandomTextENMethod =
              io.grpc.MethodDescriptor.<org.csystem.generator.random.text.RandomTextGeneratorRequest, org.csystem.generator.random.text.RandomTextGeneratorResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateRandomTextEN"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.csystem.generator.random.text.RandomTextGeneratorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.csystem.generator.random.text.RandomTextGeneratorResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RandomTextGeneratorServiceMethodDescriptorSupplier("GenerateRandomTextEN"))
              .build();
        }
      }
    }
    return getGenerateRandomTextENMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.csystem.generator.random.text.RandomTextGeneratorRequest,
      org.csystem.generator.random.text.RandomTextGeneratorResponse> getGenerateRandomTextTRMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateRandomTextTR",
      requestType = org.csystem.generator.random.text.RandomTextGeneratorRequest.class,
      responseType = org.csystem.generator.random.text.RandomTextGeneratorResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.csystem.generator.random.text.RandomTextGeneratorRequest,
      org.csystem.generator.random.text.RandomTextGeneratorResponse> getGenerateRandomTextTRMethod() {
    io.grpc.MethodDescriptor<org.csystem.generator.random.text.RandomTextGeneratorRequest, org.csystem.generator.random.text.RandomTextGeneratorResponse> getGenerateRandomTextTRMethod;
    if ((getGenerateRandomTextTRMethod = RandomTextGeneratorServiceGrpc.getGenerateRandomTextTRMethod) == null) {
      synchronized (RandomTextGeneratorServiceGrpc.class) {
        if ((getGenerateRandomTextTRMethod = RandomTextGeneratorServiceGrpc.getGenerateRandomTextTRMethod) == null) {
          RandomTextGeneratorServiceGrpc.getGenerateRandomTextTRMethod = getGenerateRandomTextTRMethod =
              io.grpc.MethodDescriptor.<org.csystem.generator.random.text.RandomTextGeneratorRequest, org.csystem.generator.random.text.RandomTextGeneratorResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateRandomTextTR"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.csystem.generator.random.text.RandomTextGeneratorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.csystem.generator.random.text.RandomTextGeneratorResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RandomTextGeneratorServiceMethodDescriptorSupplier("GenerateRandomTextTR"))
              .build();
        }
      }
    }
    return getGenerateRandomTextTRMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RandomTextGeneratorServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RandomTextGeneratorServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RandomTextGeneratorServiceStub>() {
        @java.lang.Override
        public RandomTextGeneratorServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RandomTextGeneratorServiceStub(channel, callOptions);
        }
      };
    return RandomTextGeneratorServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RandomTextGeneratorServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RandomTextGeneratorServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RandomTextGeneratorServiceBlockingStub>() {
        @java.lang.Override
        public RandomTextGeneratorServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RandomTextGeneratorServiceBlockingStub(channel, callOptions);
        }
      };
    return RandomTextGeneratorServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RandomTextGeneratorServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RandomTextGeneratorServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RandomTextGeneratorServiceFutureStub>() {
        @java.lang.Override
        public RandomTextGeneratorServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RandomTextGeneratorServiceFutureStub(channel, callOptions);
        }
      };
    return RandomTextGeneratorServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class RandomTextGeneratorServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void generateRandomTextEN(org.csystem.generator.random.text.RandomTextGeneratorRequest request,
        io.grpc.stub.StreamObserver<org.csystem.generator.random.text.RandomTextGeneratorResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGenerateRandomTextENMethod(), responseObserver);
    }

    /**
     */
    public void generateRandomTextTR(org.csystem.generator.random.text.RandomTextGeneratorRequest request,
        io.grpc.stub.StreamObserver<org.csystem.generator.random.text.RandomTextGeneratorResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGenerateRandomTextTRMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGenerateRandomTextENMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.csystem.generator.random.text.RandomTextGeneratorRequest,
                org.csystem.generator.random.text.RandomTextGeneratorResponse>(
                  this, METHODID_GENERATE_RANDOM_TEXT_EN)))
          .addMethod(
            getGenerateRandomTextTRMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.csystem.generator.random.text.RandomTextGeneratorRequest,
                org.csystem.generator.random.text.RandomTextGeneratorResponse>(
                  this, METHODID_GENERATE_RANDOM_TEXT_TR)))
          .build();
    }
  }

  /**
   */
  public static final class RandomTextGeneratorServiceStub extends io.grpc.stub.AbstractAsyncStub<RandomTextGeneratorServiceStub> {
    private RandomTextGeneratorServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RandomTextGeneratorServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RandomTextGeneratorServiceStub(channel, callOptions);
    }

    /**
     */
    public void generateRandomTextEN(org.csystem.generator.random.text.RandomTextGeneratorRequest request,
        io.grpc.stub.StreamObserver<org.csystem.generator.random.text.RandomTextGeneratorResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateRandomTextENMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void generateRandomTextTR(org.csystem.generator.random.text.RandomTextGeneratorRequest request,
        io.grpc.stub.StreamObserver<org.csystem.generator.random.text.RandomTextGeneratorResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateRandomTextTRMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RandomTextGeneratorServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<RandomTextGeneratorServiceBlockingStub> {
    private RandomTextGeneratorServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RandomTextGeneratorServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RandomTextGeneratorServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public org.csystem.generator.random.text.RandomTextGeneratorResponse generateRandomTextEN(org.csystem.generator.random.text.RandomTextGeneratorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateRandomTextENMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.csystem.generator.random.text.RandomTextGeneratorResponse generateRandomTextTR(org.csystem.generator.random.text.RandomTextGeneratorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateRandomTextTRMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RandomTextGeneratorServiceFutureStub extends io.grpc.stub.AbstractFutureStub<RandomTextGeneratorServiceFutureStub> {
    private RandomTextGeneratorServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RandomTextGeneratorServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RandomTextGeneratorServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.csystem.generator.random.text.RandomTextGeneratorResponse> generateRandomTextEN(
        org.csystem.generator.random.text.RandomTextGeneratorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateRandomTextENMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.csystem.generator.random.text.RandomTextGeneratorResponse> generateRandomTextTR(
        org.csystem.generator.random.text.RandomTextGeneratorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateRandomTextTRMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GENERATE_RANDOM_TEXT_EN = 0;
  private static final int METHODID_GENERATE_RANDOM_TEXT_TR = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RandomTextGeneratorServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RandomTextGeneratorServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GENERATE_RANDOM_TEXT_EN:
          serviceImpl.generateRandomTextEN((org.csystem.generator.random.text.RandomTextGeneratorRequest) request,
              (io.grpc.stub.StreamObserver<org.csystem.generator.random.text.RandomTextGeneratorResponse>) responseObserver);
          break;
        case METHODID_GENERATE_RANDOM_TEXT_TR:
          serviceImpl.generateRandomTextTR((org.csystem.generator.random.text.RandomTextGeneratorRequest) request,
              (io.grpc.stub.StreamObserver<org.csystem.generator.random.text.RandomTextGeneratorResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class RandomTextGeneratorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RandomTextGeneratorServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.csystem.generator.random.text.Randomtextgenerator.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RandomTextGeneratorService");
    }
  }

  private static final class RandomTextGeneratorServiceFileDescriptorSupplier
      extends RandomTextGeneratorServiceBaseDescriptorSupplier {
    RandomTextGeneratorServiceFileDescriptorSupplier() {}
  }

  private static final class RandomTextGeneratorServiceMethodDescriptorSupplier
      extends RandomTextGeneratorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RandomTextGeneratorServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (RandomTextGeneratorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RandomTextGeneratorServiceFileDescriptorSupplier())
              .addMethod(getGenerateRandomTextENMethod())
              .addMethod(getGenerateRandomTextTRMethod())
              .build();
        }
      }
    }
    return result;
  }
}
