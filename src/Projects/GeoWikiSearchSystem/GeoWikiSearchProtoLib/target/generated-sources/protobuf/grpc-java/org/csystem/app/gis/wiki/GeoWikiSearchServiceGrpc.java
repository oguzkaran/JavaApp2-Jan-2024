package org.csystem.app.gis.wiki;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.45.1)",
    comments = "Source: geowikisearch.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class GeoWikiSearchServiceGrpc {

  private GeoWikiSearchServiceGrpc() {}

  public static final String SERVICE_NAME = "org.csystem.app.gis.wiki.GeoWikiSearchService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.csystem.app.gis.wiki.GeoWikiSearchRequest,
      org.csystem.app.gis.wiki.GeoWikiSearchInfo> getFindWikiSearchInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindWikiSearchInfo",
      requestType = org.csystem.app.gis.wiki.GeoWikiSearchRequest.class,
      responseType = org.csystem.app.gis.wiki.GeoWikiSearchInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<org.csystem.app.gis.wiki.GeoWikiSearchRequest,
      org.csystem.app.gis.wiki.GeoWikiSearchInfo> getFindWikiSearchInfoMethod() {
    io.grpc.MethodDescriptor<org.csystem.app.gis.wiki.GeoWikiSearchRequest, org.csystem.app.gis.wiki.GeoWikiSearchInfo> getFindWikiSearchInfoMethod;
    if ((getFindWikiSearchInfoMethod = GeoWikiSearchServiceGrpc.getFindWikiSearchInfoMethod) == null) {
      synchronized (GeoWikiSearchServiceGrpc.class) {
        if ((getFindWikiSearchInfoMethod = GeoWikiSearchServiceGrpc.getFindWikiSearchInfoMethod) == null) {
          GeoWikiSearchServiceGrpc.getFindWikiSearchInfoMethod = getFindWikiSearchInfoMethod =
              io.grpc.MethodDescriptor.<org.csystem.app.gis.wiki.GeoWikiSearchRequest, org.csystem.app.gis.wiki.GeoWikiSearchInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FindWikiSearchInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.csystem.app.gis.wiki.GeoWikiSearchRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.csystem.app.gis.wiki.GeoWikiSearchInfo.getDefaultInstance()))
              .setSchemaDescriptor(new GeoWikiSearchServiceMethodDescriptorSupplier("FindWikiSearchInfo"))
              .build();
        }
      }
    }
    return getFindWikiSearchInfoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GeoWikiSearchServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GeoWikiSearchServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GeoWikiSearchServiceStub>() {
        @java.lang.Override
        public GeoWikiSearchServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GeoWikiSearchServiceStub(channel, callOptions);
        }
      };
    return GeoWikiSearchServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GeoWikiSearchServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GeoWikiSearchServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GeoWikiSearchServiceBlockingStub>() {
        @java.lang.Override
        public GeoWikiSearchServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GeoWikiSearchServiceBlockingStub(channel, callOptions);
        }
      };
    return GeoWikiSearchServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GeoWikiSearchServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GeoWikiSearchServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GeoWikiSearchServiceFutureStub>() {
        @java.lang.Override
        public GeoWikiSearchServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GeoWikiSearchServiceFutureStub(channel, callOptions);
        }
      };
    return GeoWikiSearchServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class GeoWikiSearchServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void findWikiSearchInfo(org.csystem.app.gis.wiki.GeoWikiSearchRequest request,
        io.grpc.stub.StreamObserver<org.csystem.app.gis.wiki.GeoWikiSearchInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindWikiSearchInfoMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getFindWikiSearchInfoMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                org.csystem.app.gis.wiki.GeoWikiSearchRequest,
                org.csystem.app.gis.wiki.GeoWikiSearchInfo>(
                  this, METHODID_FIND_WIKI_SEARCH_INFO)))
          .build();
    }
  }

  /**
   */
  public static final class GeoWikiSearchServiceStub extends io.grpc.stub.AbstractAsyncStub<GeoWikiSearchServiceStub> {
    private GeoWikiSearchServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GeoWikiSearchServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GeoWikiSearchServiceStub(channel, callOptions);
    }

    /**
     */
    public void findWikiSearchInfo(org.csystem.app.gis.wiki.GeoWikiSearchRequest request,
        io.grpc.stub.StreamObserver<org.csystem.app.gis.wiki.GeoWikiSearchInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getFindWikiSearchInfoMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class GeoWikiSearchServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<GeoWikiSearchServiceBlockingStub> {
    private GeoWikiSearchServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GeoWikiSearchServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GeoWikiSearchServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<org.csystem.app.gis.wiki.GeoWikiSearchInfo> findWikiSearchInfo(
        org.csystem.app.gis.wiki.GeoWikiSearchRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getFindWikiSearchInfoMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class GeoWikiSearchServiceFutureStub extends io.grpc.stub.AbstractFutureStub<GeoWikiSearchServiceFutureStub> {
    private GeoWikiSearchServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GeoWikiSearchServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GeoWikiSearchServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_FIND_WIKI_SEARCH_INFO = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GeoWikiSearchServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GeoWikiSearchServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FIND_WIKI_SEARCH_INFO:
          serviceImpl.findWikiSearchInfo((org.csystem.app.gis.wiki.GeoWikiSearchRequest) request,
              (io.grpc.stub.StreamObserver<org.csystem.app.gis.wiki.GeoWikiSearchInfo>) responseObserver);
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

  private static abstract class GeoWikiSearchServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GeoWikiSearchServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.csystem.app.gis.wiki.Geowikisearch.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GeoWikiSearchService");
    }
  }

  private static final class GeoWikiSearchServiceFileDescriptorSupplier
      extends GeoWikiSearchServiceBaseDescriptorSupplier {
    GeoWikiSearchServiceFileDescriptorSupplier() {}
  }

  private static final class GeoWikiSearchServiceMethodDescriptorSupplier
      extends GeoWikiSearchServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GeoWikiSearchServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (GeoWikiSearchServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GeoWikiSearchServiceFileDescriptorSupplier())
              .addMethod(getFindWikiSearchInfoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
