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
  private static volatile io.grpc.MethodDescriptor<org.csystem.generator.random.text.TextGeneratorRequest,
      org.csystem.generator.random.text.TextGeneratorResponse> getGenerateTextENMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateTextEN",
      requestType = org.csystem.generator.random.text.TextGeneratorRequest.class,
      responseType = org.csystem.generator.random.text.TextGeneratorResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.csystem.generator.random.text.TextGeneratorRequest,
      org.csystem.generator.random.text.TextGeneratorResponse> getGenerateTextENMethod() {
    io.grpc.MethodDescriptor<org.csystem.generator.random.text.TextGeneratorRequest, org.csystem.generator.random.text.TextGeneratorResponse> getGenerateTextENMethod;
    if ((getGenerateTextENMethod = RandomTextGeneratorServiceGrpc.getGenerateTextENMethod) == null) {
      synchronized (RandomTextGeneratorServiceGrpc.class) {
        if ((getGenerateTextENMethod = RandomTextGeneratorServiceGrpc.getGenerateTextENMethod) == null) {
          RandomTextGeneratorServiceGrpc.getGenerateTextENMethod = getGenerateTextENMethod =
              io.grpc.MethodDescriptor.<org.csystem.generator.random.text.TextGeneratorRequest, org.csystem.generator.random.text.TextGeneratorResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateTextEN"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.csystem.generator.random.text.TextGeneratorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.csystem.generator.random.text.TextGeneratorResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RandomTextGeneratorServiceMethodDescriptorSupplier("GenerateTextEN"))
              .build();
        }
      }
    }
    return getGenerateTextENMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.csystem.generator.random.text.TextGeneratorRequest,
      org.csystem.generator.random.text.TextGeneratorResponse> getGenerateTextTRMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateTextTR",
      requestType = org.csystem.generator.random.text.TextGeneratorRequest.class,
      responseType = org.csystem.generator.random.text.TextGeneratorResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.csystem.generator.random.text.TextGeneratorRequest,
      org.csystem.generator.random.text.TextGeneratorResponse> getGenerateTextTRMethod() {
    io.grpc.MethodDescriptor<org.csystem.generator.random.text.TextGeneratorRequest, org.csystem.generator.random.text.TextGeneratorResponse> getGenerateTextTRMethod;
    if ((getGenerateTextTRMethod = RandomTextGeneratorServiceGrpc.getGenerateTextTRMethod) == null) {
      synchronized (RandomTextGeneratorServiceGrpc.class) {
        if ((getGenerateTextTRMethod = RandomTextGeneratorServiceGrpc.getGenerateTextTRMethod) == null) {
          RandomTextGeneratorServiceGrpc.getGenerateTextTRMethod = getGenerateTextTRMethod =
              io.grpc.MethodDescriptor.<org.csystem.generator.random.text.TextGeneratorRequest, org.csystem.generator.random.text.TextGeneratorResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateTextTR"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.csystem.generator.random.text.TextGeneratorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.csystem.generator.random.text.TextGeneratorResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RandomTextGeneratorServiceMethodDescriptorSupplier("GenerateTextTR"))
              .build();
        }
      }
    }
    return getGenerateTextTRMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.csystem.generator.random.text.NoParam,
      org.csystem.generator.random.text.TextBound> getGetBoundMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBound",
      requestType = org.csystem.generator.random.text.NoParam.class,
      responseType = org.csystem.generator.random.text.TextBound.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.csystem.generator.random.text.NoParam,
      org.csystem.generator.random.text.TextBound> getGetBoundMethod() {
    io.grpc.MethodDescriptor<org.csystem.generator.random.text.NoParam, org.csystem.generator.random.text.TextBound> getGetBoundMethod;
    if ((getGetBoundMethod = RandomTextGeneratorServiceGrpc.getGetBoundMethod) == null) {
      synchronized (RandomTextGeneratorServiceGrpc.class) {
        if ((getGetBoundMethod = RandomTextGeneratorServiceGrpc.getGetBoundMethod) == null) {
          RandomTextGeneratorServiceGrpc.getGetBoundMethod = getGetBoundMethod =
              io.grpc.MethodDescriptor.<org.csystem.generator.random.text.NoParam, org.csystem.generator.random.text.TextBound>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBound"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.csystem.generator.random.text.NoParam.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.csystem.generator.random.text.TextBound.getDefaultInstance()))
              .setSchemaDescriptor(new RandomTextGeneratorServiceMethodDescriptorSupplier("GetBound"))
              .build();
        }
      }
    }
    return getGetBoundMethod;
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
    public void generateTextEN(org.csystem.generator.random.text.TextGeneratorRequest request,
        io.grpc.stub.StreamObserver<org.csystem.generator.random.text.TextGeneratorResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGenerateTextENMethod(), responseObserver);
    }

    /**
     */
    public void generateTextTR(org.csystem.generator.random.text.TextGeneratorRequest request,
        io.grpc.stub.StreamObserver<org.csystem.generator.random.text.TextGeneratorResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGenerateTextTRMethod(), responseObserver);
    }

    /**
     */
    public void getBound(org.csystem.generator.random.text.NoParam request,
        io.grpc.stub.StreamObserver<org.csystem.generator.random.text.TextBound> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetBoundMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGenerateTextENMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.csystem.generator.random.text.TextGeneratorRequest,
                org.csystem.generator.random.text.TextGeneratorResponse>(
                  this, METHODID_GENERATE_TEXT_EN)))
          .addMethod(
            getGenerateTextTRMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.csystem.generator.random.text.TextGeneratorRequest,
                org.csystem.generator.random.text.TextGeneratorResponse>(
                  this, METHODID_GENERATE_TEXT_TR)))
          .addMethod(
            getGetBoundMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.csystem.generator.random.text.NoParam,
                org.csystem.generator.random.text.TextBound>(
                  this, METHODID_GET_BOUND)))
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
    public void generateTextEN(org.csystem.generator.random.text.TextGeneratorRequest request,
        io.grpc.stub.StreamObserver<org.csystem.generator.random.text.TextGeneratorResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateTextENMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void generateTextTR(org.csystem.generator.random.text.TextGeneratorRequest request,
        io.grpc.stub.StreamObserver<org.csystem.generator.random.text.TextGeneratorResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateTextTRMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getBound(org.csystem.generator.random.text.NoParam request,
        io.grpc.stub.StreamObserver<org.csystem.generator.random.text.TextBound> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBoundMethod(), getCallOptions()), request, responseObserver);
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
    public org.csystem.generator.random.text.TextGeneratorResponse generateTextEN(org.csystem.generator.random.text.TextGeneratorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateTextENMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.csystem.generator.random.text.TextGeneratorResponse generateTextTR(org.csystem.generator.random.text.TextGeneratorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateTextTRMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.csystem.generator.random.text.TextBound getBound(org.csystem.generator.random.text.NoParam request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBoundMethod(), getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<org.csystem.generator.random.text.TextGeneratorResponse> generateTextEN(
        org.csystem.generator.random.text.TextGeneratorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateTextENMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.csystem.generator.random.text.TextGeneratorResponse> generateTextTR(
        org.csystem.generator.random.text.TextGeneratorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateTextTRMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.csystem.generator.random.text.TextBound> getBound(
        org.csystem.generator.random.text.NoParam request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBoundMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GENERATE_TEXT_EN = 0;
  private static final int METHODID_GENERATE_TEXT_TR = 1;
  private static final int METHODID_GET_BOUND = 2;

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
        case METHODID_GENERATE_TEXT_EN:
          serviceImpl.generateTextEN((org.csystem.generator.random.text.TextGeneratorRequest) request,
              (io.grpc.stub.StreamObserver<org.csystem.generator.random.text.TextGeneratorResponse>) responseObserver);
          break;
        case METHODID_GENERATE_TEXT_TR:
          serviceImpl.generateTextTR((org.csystem.generator.random.text.TextGeneratorRequest) request,
              (io.grpc.stub.StreamObserver<org.csystem.generator.random.text.TextGeneratorResponse>) responseObserver);
          break;
        case METHODID_GET_BOUND:
          serviceImpl.getBound((org.csystem.generator.random.text.NoParam) request,
              (io.grpc.stub.StreamObserver<org.csystem.generator.random.text.TextBound>) responseObserver);
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
              .addMethod(getGenerateTextENMethod())
              .addMethod(getGenerateTextTRMethod())
              .addMethod(getGetBoundMethod())
              .build();
        }
      }
    }
    return result;
  }
}
