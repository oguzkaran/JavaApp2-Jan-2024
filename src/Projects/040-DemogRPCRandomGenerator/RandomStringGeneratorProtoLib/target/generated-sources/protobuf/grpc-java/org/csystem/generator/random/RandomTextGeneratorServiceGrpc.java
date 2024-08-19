package org.csystem.generator.random;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.45.1)",
    comments = "Source: randomgenerator.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RandomTextGeneratorServiceGrpc {

  private RandomTextGeneratorServiceGrpc() {}

  public static final String SERVICE_NAME = "org.csystem.generator.random.RandomTextGeneratorService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.csystem.generator.random.TextGenerateInfo,
      org.csystem.generator.random.TextInfo> getGenerateTextENMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateTextEN",
      requestType = org.csystem.generator.random.TextGenerateInfo.class,
      responseType = org.csystem.generator.random.TextInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.csystem.generator.random.TextGenerateInfo,
      org.csystem.generator.random.TextInfo> getGenerateTextENMethod() {
    io.grpc.MethodDescriptor<org.csystem.generator.random.TextGenerateInfo, org.csystem.generator.random.TextInfo> getGenerateTextENMethod;
    if ((getGenerateTextENMethod = RandomTextGeneratorServiceGrpc.getGenerateTextENMethod) == null) {
      synchronized (RandomTextGeneratorServiceGrpc.class) {
        if ((getGenerateTextENMethod = RandomTextGeneratorServiceGrpc.getGenerateTextENMethod) == null) {
          RandomTextGeneratorServiceGrpc.getGenerateTextENMethod = getGenerateTextENMethod =
              io.grpc.MethodDescriptor.<org.csystem.generator.random.TextGenerateInfo, org.csystem.generator.random.TextInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateTextEN"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.csystem.generator.random.TextGenerateInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.csystem.generator.random.TextInfo.getDefaultInstance()))
              .setSchemaDescriptor(new RandomTextGeneratorServiceMethodDescriptorSupplier("GenerateTextEN"))
              .build();
        }
      }
    }
    return getGenerateTextENMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.csystem.generator.random.TextGenerateInfo,
      org.csystem.generator.random.TextInfo> getGenerateTextTRMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateTextTR",
      requestType = org.csystem.generator.random.TextGenerateInfo.class,
      responseType = org.csystem.generator.random.TextInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.csystem.generator.random.TextGenerateInfo,
      org.csystem.generator.random.TextInfo> getGenerateTextTRMethod() {
    io.grpc.MethodDescriptor<org.csystem.generator.random.TextGenerateInfo, org.csystem.generator.random.TextInfo> getGenerateTextTRMethod;
    if ((getGenerateTextTRMethod = RandomTextGeneratorServiceGrpc.getGenerateTextTRMethod) == null) {
      synchronized (RandomTextGeneratorServiceGrpc.class) {
        if ((getGenerateTextTRMethod = RandomTextGeneratorServiceGrpc.getGenerateTextTRMethod) == null) {
          RandomTextGeneratorServiceGrpc.getGenerateTextTRMethod = getGenerateTextTRMethod =
              io.grpc.MethodDescriptor.<org.csystem.generator.random.TextGenerateInfo, org.csystem.generator.random.TextInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateTextTR"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.csystem.generator.random.TextGenerateInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.csystem.generator.random.TextInfo.getDefaultInstance()))
              .setSchemaDescriptor(new RandomTextGeneratorServiceMethodDescriptorSupplier("GenerateTextTR"))
              .build();
        }
      }
    }
    return getGenerateTextTRMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.csystem.generator.random.TextsGenerateInfo,
      org.csystem.generator.random.TextInfo> getGenerateTextsENMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateTextsEN",
      requestType = org.csystem.generator.random.TextsGenerateInfo.class,
      responseType = org.csystem.generator.random.TextInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<org.csystem.generator.random.TextsGenerateInfo,
      org.csystem.generator.random.TextInfo> getGenerateTextsENMethod() {
    io.grpc.MethodDescriptor<org.csystem.generator.random.TextsGenerateInfo, org.csystem.generator.random.TextInfo> getGenerateTextsENMethod;
    if ((getGenerateTextsENMethod = RandomTextGeneratorServiceGrpc.getGenerateTextsENMethod) == null) {
      synchronized (RandomTextGeneratorServiceGrpc.class) {
        if ((getGenerateTextsENMethod = RandomTextGeneratorServiceGrpc.getGenerateTextsENMethod) == null) {
          RandomTextGeneratorServiceGrpc.getGenerateTextsENMethod = getGenerateTextsENMethod =
              io.grpc.MethodDescriptor.<org.csystem.generator.random.TextsGenerateInfo, org.csystem.generator.random.TextInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateTextsEN"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.csystem.generator.random.TextsGenerateInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.csystem.generator.random.TextInfo.getDefaultInstance()))
              .setSchemaDescriptor(new RandomTextGeneratorServiceMethodDescriptorSupplier("GenerateTextsEN"))
              .build();
        }
      }
    }
    return getGenerateTextsENMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.csystem.generator.random.TextsGenerateInfo,
      org.csystem.generator.random.TextInfo> getGenerateTextsTRMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateTextsTR",
      requestType = org.csystem.generator.random.TextsGenerateInfo.class,
      responseType = org.csystem.generator.random.TextInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<org.csystem.generator.random.TextsGenerateInfo,
      org.csystem.generator.random.TextInfo> getGenerateTextsTRMethod() {
    io.grpc.MethodDescriptor<org.csystem.generator.random.TextsGenerateInfo, org.csystem.generator.random.TextInfo> getGenerateTextsTRMethod;
    if ((getGenerateTextsTRMethod = RandomTextGeneratorServiceGrpc.getGenerateTextsTRMethod) == null) {
      synchronized (RandomTextGeneratorServiceGrpc.class) {
        if ((getGenerateTextsTRMethod = RandomTextGeneratorServiceGrpc.getGenerateTextsTRMethod) == null) {
          RandomTextGeneratorServiceGrpc.getGenerateTextsTRMethod = getGenerateTextsTRMethod =
              io.grpc.MethodDescriptor.<org.csystem.generator.random.TextsGenerateInfo, org.csystem.generator.random.TextInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateTextsTR"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.csystem.generator.random.TextsGenerateInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.csystem.generator.random.TextInfo.getDefaultInstance()))
              .setSchemaDescriptor(new RandomTextGeneratorServiceMethodDescriptorSupplier("GenerateTextsTR"))
              .build();
        }
      }
    }
    return getGenerateTextsTRMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.csystem.generator.random.TextGenerateInfo,
      org.csystem.generator.random.TextInfo> getGenerateAndJoinTextsENMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateAndJoinTextsEN",
      requestType = org.csystem.generator.random.TextGenerateInfo.class,
      responseType = org.csystem.generator.random.TextInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<org.csystem.generator.random.TextGenerateInfo,
      org.csystem.generator.random.TextInfo> getGenerateAndJoinTextsENMethod() {
    io.grpc.MethodDescriptor<org.csystem.generator.random.TextGenerateInfo, org.csystem.generator.random.TextInfo> getGenerateAndJoinTextsENMethod;
    if ((getGenerateAndJoinTextsENMethod = RandomTextGeneratorServiceGrpc.getGenerateAndJoinTextsENMethod) == null) {
      synchronized (RandomTextGeneratorServiceGrpc.class) {
        if ((getGenerateAndJoinTextsENMethod = RandomTextGeneratorServiceGrpc.getGenerateAndJoinTextsENMethod) == null) {
          RandomTextGeneratorServiceGrpc.getGenerateAndJoinTextsENMethod = getGenerateAndJoinTextsENMethod =
              io.grpc.MethodDescriptor.<org.csystem.generator.random.TextGenerateInfo, org.csystem.generator.random.TextInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateAndJoinTextsEN"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.csystem.generator.random.TextGenerateInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.csystem.generator.random.TextInfo.getDefaultInstance()))
              .setSchemaDescriptor(new RandomTextGeneratorServiceMethodDescriptorSupplier("GenerateAndJoinTextsEN"))
              .build();
        }
      }
    }
    return getGenerateAndJoinTextsENMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.csystem.generator.random.TextGenerateInfo,
      org.csystem.generator.random.TextInfo> getGenerateAndJoinTextsTRMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateAndJoinTextsTR",
      requestType = org.csystem.generator.random.TextGenerateInfo.class,
      responseType = org.csystem.generator.random.TextInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<org.csystem.generator.random.TextGenerateInfo,
      org.csystem.generator.random.TextInfo> getGenerateAndJoinTextsTRMethod() {
    io.grpc.MethodDescriptor<org.csystem.generator.random.TextGenerateInfo, org.csystem.generator.random.TextInfo> getGenerateAndJoinTextsTRMethod;
    if ((getGenerateAndJoinTextsTRMethod = RandomTextGeneratorServiceGrpc.getGenerateAndJoinTextsTRMethod) == null) {
      synchronized (RandomTextGeneratorServiceGrpc.class) {
        if ((getGenerateAndJoinTextsTRMethod = RandomTextGeneratorServiceGrpc.getGenerateAndJoinTextsTRMethod) == null) {
          RandomTextGeneratorServiceGrpc.getGenerateAndJoinTextsTRMethod = getGenerateAndJoinTextsTRMethod =
              io.grpc.MethodDescriptor.<org.csystem.generator.random.TextGenerateInfo, org.csystem.generator.random.TextInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateAndJoinTextsTR"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.csystem.generator.random.TextGenerateInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.csystem.generator.random.TextInfo.getDefaultInstance()))
              .setSchemaDescriptor(new RandomTextGeneratorServiceMethodDescriptorSupplier("GenerateAndJoinTextsTR"))
              .build();
        }
      }
    }
    return getGenerateAndJoinTextsTRMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.csystem.generator.random.TextGenerateInfo,
      org.csystem.generator.random.TextInfo> getGenerateMultipleTextsENMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateMultipleTextsEN",
      requestType = org.csystem.generator.random.TextGenerateInfo.class,
      responseType = org.csystem.generator.random.TextInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<org.csystem.generator.random.TextGenerateInfo,
      org.csystem.generator.random.TextInfo> getGenerateMultipleTextsENMethod() {
    io.grpc.MethodDescriptor<org.csystem.generator.random.TextGenerateInfo, org.csystem.generator.random.TextInfo> getGenerateMultipleTextsENMethod;
    if ((getGenerateMultipleTextsENMethod = RandomTextGeneratorServiceGrpc.getGenerateMultipleTextsENMethod) == null) {
      synchronized (RandomTextGeneratorServiceGrpc.class) {
        if ((getGenerateMultipleTextsENMethod = RandomTextGeneratorServiceGrpc.getGenerateMultipleTextsENMethod) == null) {
          RandomTextGeneratorServiceGrpc.getGenerateMultipleTextsENMethod = getGenerateMultipleTextsENMethod =
              io.grpc.MethodDescriptor.<org.csystem.generator.random.TextGenerateInfo, org.csystem.generator.random.TextInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateMultipleTextsEN"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.csystem.generator.random.TextGenerateInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.csystem.generator.random.TextInfo.getDefaultInstance()))
              .setSchemaDescriptor(new RandomTextGeneratorServiceMethodDescriptorSupplier("GenerateMultipleTextsEN"))
              .build();
        }
      }
    }
    return getGenerateMultipleTextsENMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.csystem.generator.random.TextGenerateInfo,
      org.csystem.generator.random.TextInfo> getGenerateMultipleTextsTRMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateMultipleTextsTR",
      requestType = org.csystem.generator.random.TextGenerateInfo.class,
      responseType = org.csystem.generator.random.TextInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<org.csystem.generator.random.TextGenerateInfo,
      org.csystem.generator.random.TextInfo> getGenerateMultipleTextsTRMethod() {
    io.grpc.MethodDescriptor<org.csystem.generator.random.TextGenerateInfo, org.csystem.generator.random.TextInfo> getGenerateMultipleTextsTRMethod;
    if ((getGenerateMultipleTextsTRMethod = RandomTextGeneratorServiceGrpc.getGenerateMultipleTextsTRMethod) == null) {
      synchronized (RandomTextGeneratorServiceGrpc.class) {
        if ((getGenerateMultipleTextsTRMethod = RandomTextGeneratorServiceGrpc.getGenerateMultipleTextsTRMethod) == null) {
          RandomTextGeneratorServiceGrpc.getGenerateMultipleTextsTRMethod = getGenerateMultipleTextsTRMethod =
              io.grpc.MethodDescriptor.<org.csystem.generator.random.TextGenerateInfo, org.csystem.generator.random.TextInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateMultipleTextsTR"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.csystem.generator.random.TextGenerateInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.csystem.generator.random.TextInfo.getDefaultInstance()))
              .setSchemaDescriptor(new RandomTextGeneratorServiceMethodDescriptorSupplier("GenerateMultipleTextsTR"))
              .build();
        }
      }
    }
    return getGenerateMultipleTextsTRMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.csystem.generator.random.NoParam,
      org.csystem.generator.random.TextBound> getGetTextBoundMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTextBound",
      requestType = org.csystem.generator.random.NoParam.class,
      responseType = org.csystem.generator.random.TextBound.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.csystem.generator.random.NoParam,
      org.csystem.generator.random.TextBound> getGetTextBoundMethod() {
    io.grpc.MethodDescriptor<org.csystem.generator.random.NoParam, org.csystem.generator.random.TextBound> getGetTextBoundMethod;
    if ((getGetTextBoundMethod = RandomTextGeneratorServiceGrpc.getGetTextBoundMethod) == null) {
      synchronized (RandomTextGeneratorServiceGrpc.class) {
        if ((getGetTextBoundMethod = RandomTextGeneratorServiceGrpc.getGetTextBoundMethod) == null) {
          RandomTextGeneratorServiceGrpc.getGetTextBoundMethod = getGetTextBoundMethod =
              io.grpc.MethodDescriptor.<org.csystem.generator.random.NoParam, org.csystem.generator.random.TextBound>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTextBound"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.csystem.generator.random.NoParam.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.csystem.generator.random.TextBound.getDefaultInstance()))
              .setSchemaDescriptor(new RandomTextGeneratorServiceMethodDescriptorSupplier("GetTextBound"))
              .build();
        }
      }
    }
    return getGetTextBoundMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.csystem.generator.random.Int32GenerateInfo,
      org.csystem.generator.random.Int32Result> getGenerateInt32Method;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateInt32",
      requestType = org.csystem.generator.random.Int32GenerateInfo.class,
      responseType = org.csystem.generator.random.Int32Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.csystem.generator.random.Int32GenerateInfo,
      org.csystem.generator.random.Int32Result> getGenerateInt32Method() {
    io.grpc.MethodDescriptor<org.csystem.generator.random.Int32GenerateInfo, org.csystem.generator.random.Int32Result> getGenerateInt32Method;
    if ((getGenerateInt32Method = RandomTextGeneratorServiceGrpc.getGenerateInt32Method) == null) {
      synchronized (RandomTextGeneratorServiceGrpc.class) {
        if ((getGenerateInt32Method = RandomTextGeneratorServiceGrpc.getGenerateInt32Method) == null) {
          RandomTextGeneratorServiceGrpc.getGenerateInt32Method = getGenerateInt32Method =
              io.grpc.MethodDescriptor.<org.csystem.generator.random.Int32GenerateInfo, org.csystem.generator.random.Int32Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateInt32"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.csystem.generator.random.Int32GenerateInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.csystem.generator.random.Int32Result.getDefaultInstance()))
              .setSchemaDescriptor(new RandomTextGeneratorServiceMethodDescriptorSupplier("GenerateInt32"))
              .build();
        }
      }
    }
    return getGenerateInt32Method;
  }

  private static volatile io.grpc.MethodDescriptor<org.csystem.generator.random.DoubleGenerateInfo,
      org.csystem.generator.random.DoubleResult> getGenerateDoubleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateDouble",
      requestType = org.csystem.generator.random.DoubleGenerateInfo.class,
      responseType = org.csystem.generator.random.DoubleResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.csystem.generator.random.DoubleGenerateInfo,
      org.csystem.generator.random.DoubleResult> getGenerateDoubleMethod() {
    io.grpc.MethodDescriptor<org.csystem.generator.random.DoubleGenerateInfo, org.csystem.generator.random.DoubleResult> getGenerateDoubleMethod;
    if ((getGenerateDoubleMethod = RandomTextGeneratorServiceGrpc.getGenerateDoubleMethod) == null) {
      synchronized (RandomTextGeneratorServiceGrpc.class) {
        if ((getGenerateDoubleMethod = RandomTextGeneratorServiceGrpc.getGenerateDoubleMethod) == null) {
          RandomTextGeneratorServiceGrpc.getGenerateDoubleMethod = getGenerateDoubleMethod =
              io.grpc.MethodDescriptor.<org.csystem.generator.random.DoubleGenerateInfo, org.csystem.generator.random.DoubleResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateDouble"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.csystem.generator.random.DoubleGenerateInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.csystem.generator.random.DoubleResult.getDefaultInstance()))
              .setSchemaDescriptor(new RandomTextGeneratorServiceMethodDescriptorSupplier("GenerateDouble"))
              .build();
        }
      }
    }
    return getGenerateDoubleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.csystem.generator.random.Int64GenerateInfo,
      org.csystem.generator.random.Int64Result> getGenerateInt64Method;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateInt64",
      requestType = org.csystem.generator.random.Int64GenerateInfo.class,
      responseType = org.csystem.generator.random.Int64Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.csystem.generator.random.Int64GenerateInfo,
      org.csystem.generator.random.Int64Result> getGenerateInt64Method() {
    io.grpc.MethodDescriptor<org.csystem.generator.random.Int64GenerateInfo, org.csystem.generator.random.Int64Result> getGenerateInt64Method;
    if ((getGenerateInt64Method = RandomTextGeneratorServiceGrpc.getGenerateInt64Method) == null) {
      synchronized (RandomTextGeneratorServiceGrpc.class) {
        if ((getGenerateInt64Method = RandomTextGeneratorServiceGrpc.getGenerateInt64Method) == null) {
          RandomTextGeneratorServiceGrpc.getGenerateInt64Method = getGenerateInt64Method =
              io.grpc.MethodDescriptor.<org.csystem.generator.random.Int64GenerateInfo, org.csystem.generator.random.Int64Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateInt64"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.csystem.generator.random.Int64GenerateInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.csystem.generator.random.Int64Result.getDefaultInstance()))
              .setSchemaDescriptor(new RandomTextGeneratorServiceMethodDescriptorSupplier("GenerateInt64"))
              .build();
        }
      }
    }
    return getGenerateInt64Method;
  }

  private static volatile io.grpc.MethodDescriptor<org.csystem.generator.random.Int32sGenerateInfo,
      org.csystem.generator.random.Int32Result> getGenerateInt32sMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateInt32s",
      requestType = org.csystem.generator.random.Int32sGenerateInfo.class,
      responseType = org.csystem.generator.random.Int32Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<org.csystem.generator.random.Int32sGenerateInfo,
      org.csystem.generator.random.Int32Result> getGenerateInt32sMethod() {
    io.grpc.MethodDescriptor<org.csystem.generator.random.Int32sGenerateInfo, org.csystem.generator.random.Int32Result> getGenerateInt32sMethod;
    if ((getGenerateInt32sMethod = RandomTextGeneratorServiceGrpc.getGenerateInt32sMethod) == null) {
      synchronized (RandomTextGeneratorServiceGrpc.class) {
        if ((getGenerateInt32sMethod = RandomTextGeneratorServiceGrpc.getGenerateInt32sMethod) == null) {
          RandomTextGeneratorServiceGrpc.getGenerateInt32sMethod = getGenerateInt32sMethod =
              io.grpc.MethodDescriptor.<org.csystem.generator.random.Int32sGenerateInfo, org.csystem.generator.random.Int32Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateInt32s"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.csystem.generator.random.Int32sGenerateInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.csystem.generator.random.Int32Result.getDefaultInstance()))
              .setSchemaDescriptor(new RandomTextGeneratorServiceMethodDescriptorSupplier("GenerateInt32s"))
              .build();
        }
      }
    }
    return getGenerateInt32sMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.csystem.generator.random.DoublesGenerateInfo,
      org.csystem.generator.random.DoubleResult> getGenerateDoublesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateDoubles",
      requestType = org.csystem.generator.random.DoublesGenerateInfo.class,
      responseType = org.csystem.generator.random.DoubleResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<org.csystem.generator.random.DoublesGenerateInfo,
      org.csystem.generator.random.DoubleResult> getGenerateDoublesMethod() {
    io.grpc.MethodDescriptor<org.csystem.generator.random.DoublesGenerateInfo, org.csystem.generator.random.DoubleResult> getGenerateDoublesMethod;
    if ((getGenerateDoublesMethod = RandomTextGeneratorServiceGrpc.getGenerateDoublesMethod) == null) {
      synchronized (RandomTextGeneratorServiceGrpc.class) {
        if ((getGenerateDoublesMethod = RandomTextGeneratorServiceGrpc.getGenerateDoublesMethod) == null) {
          RandomTextGeneratorServiceGrpc.getGenerateDoublesMethod = getGenerateDoublesMethod =
              io.grpc.MethodDescriptor.<org.csystem.generator.random.DoublesGenerateInfo, org.csystem.generator.random.DoubleResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateDoubles"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.csystem.generator.random.DoublesGenerateInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.csystem.generator.random.DoubleResult.getDefaultInstance()))
              .setSchemaDescriptor(new RandomTextGeneratorServiceMethodDescriptorSupplier("GenerateDoubles"))
              .build();
        }
      }
    }
    return getGenerateDoublesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.csystem.generator.random.Int64sGenerateInfo,
      org.csystem.generator.random.Int64Result> getGenerateInt64sMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateInt64s",
      requestType = org.csystem.generator.random.Int64sGenerateInfo.class,
      responseType = org.csystem.generator.random.Int64Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<org.csystem.generator.random.Int64sGenerateInfo,
      org.csystem.generator.random.Int64Result> getGenerateInt64sMethod() {
    io.grpc.MethodDescriptor<org.csystem.generator.random.Int64sGenerateInfo, org.csystem.generator.random.Int64Result> getGenerateInt64sMethod;
    if ((getGenerateInt64sMethod = RandomTextGeneratorServiceGrpc.getGenerateInt64sMethod) == null) {
      synchronized (RandomTextGeneratorServiceGrpc.class) {
        if ((getGenerateInt64sMethod = RandomTextGeneratorServiceGrpc.getGenerateInt64sMethod) == null) {
          RandomTextGeneratorServiceGrpc.getGenerateInt64sMethod = getGenerateInt64sMethod =
              io.grpc.MethodDescriptor.<org.csystem.generator.random.Int64sGenerateInfo, org.csystem.generator.random.Int64Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateInt64s"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.csystem.generator.random.Int64sGenerateInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.csystem.generator.random.Int64Result.getDefaultInstance()))
              .setSchemaDescriptor(new RandomTextGeneratorServiceMethodDescriptorSupplier("GenerateInt64s"))
              .build();
        }
      }
    }
    return getGenerateInt64sMethod;
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
    public void generateTextEN(org.csystem.generator.random.TextGenerateInfo request,
        io.grpc.stub.StreamObserver<org.csystem.generator.random.TextInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGenerateTextENMethod(), responseObserver);
    }

    /**
     */
    public void generateTextTR(org.csystem.generator.random.TextGenerateInfo request,
        io.grpc.stub.StreamObserver<org.csystem.generator.random.TextInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGenerateTextTRMethod(), responseObserver);
    }

    /**
     * <pre>
     *Server side streaming RPC
     * </pre>
     */
    public void generateTextsEN(org.csystem.generator.random.TextsGenerateInfo request,
        io.grpc.stub.StreamObserver<org.csystem.generator.random.TextInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGenerateTextsENMethod(), responseObserver);
    }

    /**
     * <pre>
     *Server side streaming RPC
     * </pre>
     */
    public void generateTextsTR(org.csystem.generator.random.TextsGenerateInfo request,
        io.grpc.stub.StreamObserver<org.csystem.generator.random.TextInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGenerateTextsTRMethod(), responseObserver);
    }

    /**
     * <pre>
     *Client side streaming RPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<org.csystem.generator.random.TextGenerateInfo> generateAndJoinTextsEN(
        io.grpc.stub.StreamObserver<org.csystem.generator.random.TextInfo> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getGenerateAndJoinTextsENMethod(), responseObserver);
    }

    /**
     * <pre>
     *Client side streaming RPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<org.csystem.generator.random.TextGenerateInfo> generateAndJoinTextsTR(
        io.grpc.stub.StreamObserver<org.csystem.generator.random.TextInfo> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getGenerateAndJoinTextsTRMethod(), responseObserver);
    }

    /**
     * <pre>
     *Bidirectional streaming RPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<org.csystem.generator.random.TextGenerateInfo> generateMultipleTextsEN(
        io.grpc.stub.StreamObserver<org.csystem.generator.random.TextInfo> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getGenerateMultipleTextsENMethod(), responseObserver);
    }

    /**
     * <pre>
     *Bidirectional streaming RPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<org.csystem.generator.random.TextGenerateInfo> generateMultipleTextsTR(
        io.grpc.stub.StreamObserver<org.csystem.generator.random.TextInfo> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getGenerateMultipleTextsTRMethod(), responseObserver);
    }

    /**
     */
    public void getTextBound(org.csystem.generator.random.NoParam request,
        io.grpc.stub.StreamObserver<org.csystem.generator.random.TextBound> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTextBoundMethod(), responseObserver);
    }

    /**
     * <pre>
     *TODO
     * </pre>
     */
    public void generateInt32(org.csystem.generator.random.Int32GenerateInfo request,
        io.grpc.stub.StreamObserver<org.csystem.generator.random.Int32Result> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGenerateInt32Method(), responseObserver);
    }

    /**
     * <pre>
     *TODO
     * </pre>
     */
    public void generateDouble(org.csystem.generator.random.DoubleGenerateInfo request,
        io.grpc.stub.StreamObserver<org.csystem.generator.random.DoubleResult> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGenerateDoubleMethod(), responseObserver);
    }

    /**
     * <pre>
     *TODO
     * </pre>
     */
    public void generateInt64(org.csystem.generator.random.Int64GenerateInfo request,
        io.grpc.stub.StreamObserver<org.csystem.generator.random.Int64Result> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGenerateInt64Method(), responseObserver);
    }

    /**
     * <pre>
     *TODO
     * </pre>
     */
    public void generateInt32s(org.csystem.generator.random.Int32sGenerateInfo request,
        io.grpc.stub.StreamObserver<org.csystem.generator.random.Int32Result> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGenerateInt32sMethod(), responseObserver);
    }

    /**
     * <pre>
     *TODO
     * </pre>
     */
    public void generateDoubles(org.csystem.generator.random.DoublesGenerateInfo request,
        io.grpc.stub.StreamObserver<org.csystem.generator.random.DoubleResult> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGenerateDoublesMethod(), responseObserver);
    }

    /**
     * <pre>
     *TODO
     * </pre>
     */
    public void generateInt64s(org.csystem.generator.random.Int64sGenerateInfo request,
        io.grpc.stub.StreamObserver<org.csystem.generator.random.Int64Result> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGenerateInt64sMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGenerateTextENMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.csystem.generator.random.TextGenerateInfo,
                org.csystem.generator.random.TextInfo>(
                  this, METHODID_GENERATE_TEXT_EN)))
          .addMethod(
            getGenerateTextTRMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.csystem.generator.random.TextGenerateInfo,
                org.csystem.generator.random.TextInfo>(
                  this, METHODID_GENERATE_TEXT_TR)))
          .addMethod(
            getGenerateTextsENMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                org.csystem.generator.random.TextsGenerateInfo,
                org.csystem.generator.random.TextInfo>(
                  this, METHODID_GENERATE_TEXTS_EN)))
          .addMethod(
            getGenerateTextsTRMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                org.csystem.generator.random.TextsGenerateInfo,
                org.csystem.generator.random.TextInfo>(
                  this, METHODID_GENERATE_TEXTS_TR)))
          .addMethod(
            getGenerateAndJoinTextsENMethod(),
            io.grpc.stub.ServerCalls.asyncClientStreamingCall(
              new MethodHandlers<
                org.csystem.generator.random.TextGenerateInfo,
                org.csystem.generator.random.TextInfo>(
                  this, METHODID_GENERATE_AND_JOIN_TEXTS_EN)))
          .addMethod(
            getGenerateAndJoinTextsTRMethod(),
            io.grpc.stub.ServerCalls.asyncClientStreamingCall(
              new MethodHandlers<
                org.csystem.generator.random.TextGenerateInfo,
                org.csystem.generator.random.TextInfo>(
                  this, METHODID_GENERATE_AND_JOIN_TEXTS_TR)))
          .addMethod(
            getGenerateMultipleTextsENMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                org.csystem.generator.random.TextGenerateInfo,
                org.csystem.generator.random.TextInfo>(
                  this, METHODID_GENERATE_MULTIPLE_TEXTS_EN)))
          .addMethod(
            getGenerateMultipleTextsTRMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                org.csystem.generator.random.TextGenerateInfo,
                org.csystem.generator.random.TextInfo>(
                  this, METHODID_GENERATE_MULTIPLE_TEXTS_TR)))
          .addMethod(
            getGetTextBoundMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.csystem.generator.random.NoParam,
                org.csystem.generator.random.TextBound>(
                  this, METHODID_GET_TEXT_BOUND)))
          .addMethod(
            getGenerateInt32Method(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.csystem.generator.random.Int32GenerateInfo,
                org.csystem.generator.random.Int32Result>(
                  this, METHODID_GENERATE_INT32)))
          .addMethod(
            getGenerateDoubleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.csystem.generator.random.DoubleGenerateInfo,
                org.csystem.generator.random.DoubleResult>(
                  this, METHODID_GENERATE_DOUBLE)))
          .addMethod(
            getGenerateInt64Method(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.csystem.generator.random.Int64GenerateInfo,
                org.csystem.generator.random.Int64Result>(
                  this, METHODID_GENERATE_INT64)))
          .addMethod(
            getGenerateInt32sMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                org.csystem.generator.random.Int32sGenerateInfo,
                org.csystem.generator.random.Int32Result>(
                  this, METHODID_GENERATE_INT32S)))
          .addMethod(
            getGenerateDoublesMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                org.csystem.generator.random.DoublesGenerateInfo,
                org.csystem.generator.random.DoubleResult>(
                  this, METHODID_GENERATE_DOUBLES)))
          .addMethod(
            getGenerateInt64sMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                org.csystem.generator.random.Int64sGenerateInfo,
                org.csystem.generator.random.Int64Result>(
                  this, METHODID_GENERATE_INT64S)))
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
    public void generateTextEN(org.csystem.generator.random.TextGenerateInfo request,
        io.grpc.stub.StreamObserver<org.csystem.generator.random.TextInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateTextENMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void generateTextTR(org.csystem.generator.random.TextGenerateInfo request,
        io.grpc.stub.StreamObserver<org.csystem.generator.random.TextInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateTextTRMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Server side streaming RPC
     * </pre>
     */
    public void generateTextsEN(org.csystem.generator.random.TextsGenerateInfo request,
        io.grpc.stub.StreamObserver<org.csystem.generator.random.TextInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGenerateTextsENMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Server side streaming RPC
     * </pre>
     */
    public void generateTextsTR(org.csystem.generator.random.TextsGenerateInfo request,
        io.grpc.stub.StreamObserver<org.csystem.generator.random.TextInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGenerateTextsTRMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Client side streaming RPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<org.csystem.generator.random.TextGenerateInfo> generateAndJoinTextsEN(
        io.grpc.stub.StreamObserver<org.csystem.generator.random.TextInfo> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getGenerateAndJoinTextsENMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     *Client side streaming RPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<org.csystem.generator.random.TextGenerateInfo> generateAndJoinTextsTR(
        io.grpc.stub.StreamObserver<org.csystem.generator.random.TextInfo> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getGenerateAndJoinTextsTRMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     *Bidirectional streaming RPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<org.csystem.generator.random.TextGenerateInfo> generateMultipleTextsEN(
        io.grpc.stub.StreamObserver<org.csystem.generator.random.TextInfo> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getGenerateMultipleTextsENMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     *Bidirectional streaming RPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<org.csystem.generator.random.TextGenerateInfo> generateMultipleTextsTR(
        io.grpc.stub.StreamObserver<org.csystem.generator.random.TextInfo> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getGenerateMultipleTextsTRMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void getTextBound(org.csystem.generator.random.NoParam request,
        io.grpc.stub.StreamObserver<org.csystem.generator.random.TextBound> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTextBoundMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *TODO
     * </pre>
     */
    public void generateInt32(org.csystem.generator.random.Int32GenerateInfo request,
        io.grpc.stub.StreamObserver<org.csystem.generator.random.Int32Result> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateInt32Method(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *TODO
     * </pre>
     */
    public void generateDouble(org.csystem.generator.random.DoubleGenerateInfo request,
        io.grpc.stub.StreamObserver<org.csystem.generator.random.DoubleResult> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateDoubleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *TODO
     * </pre>
     */
    public void generateInt64(org.csystem.generator.random.Int64GenerateInfo request,
        io.grpc.stub.StreamObserver<org.csystem.generator.random.Int64Result> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateInt64Method(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *TODO
     * </pre>
     */
    public void generateInt32s(org.csystem.generator.random.Int32sGenerateInfo request,
        io.grpc.stub.StreamObserver<org.csystem.generator.random.Int32Result> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGenerateInt32sMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *TODO
     * </pre>
     */
    public void generateDoubles(org.csystem.generator.random.DoublesGenerateInfo request,
        io.grpc.stub.StreamObserver<org.csystem.generator.random.DoubleResult> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGenerateDoublesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *TODO
     * </pre>
     */
    public void generateInt64s(org.csystem.generator.random.Int64sGenerateInfo request,
        io.grpc.stub.StreamObserver<org.csystem.generator.random.Int64Result> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGenerateInt64sMethod(), getCallOptions()), request, responseObserver);
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
    public org.csystem.generator.random.TextInfo generateTextEN(org.csystem.generator.random.TextGenerateInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateTextENMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.csystem.generator.random.TextInfo generateTextTR(org.csystem.generator.random.TextGenerateInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateTextTRMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *Server side streaming RPC
     * </pre>
     */
    public java.util.Iterator<org.csystem.generator.random.TextInfo> generateTextsEN(
        org.csystem.generator.random.TextsGenerateInfo request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGenerateTextsENMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *Server side streaming RPC
     * </pre>
     */
    public java.util.Iterator<org.csystem.generator.random.TextInfo> generateTextsTR(
        org.csystem.generator.random.TextsGenerateInfo request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGenerateTextsTRMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.csystem.generator.random.TextBound getTextBound(org.csystem.generator.random.NoParam request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTextBoundMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *TODO
     * </pre>
     */
    public org.csystem.generator.random.Int32Result generateInt32(org.csystem.generator.random.Int32GenerateInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateInt32Method(), getCallOptions(), request);
    }

    /**
     * <pre>
     *TODO
     * </pre>
     */
    public org.csystem.generator.random.DoubleResult generateDouble(org.csystem.generator.random.DoubleGenerateInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateDoubleMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *TODO
     * </pre>
     */
    public org.csystem.generator.random.Int64Result generateInt64(org.csystem.generator.random.Int64GenerateInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateInt64Method(), getCallOptions(), request);
    }

    /**
     * <pre>
     *TODO
     * </pre>
     */
    public java.util.Iterator<org.csystem.generator.random.Int32Result> generateInt32s(
        org.csystem.generator.random.Int32sGenerateInfo request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGenerateInt32sMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *TODO
     * </pre>
     */
    public java.util.Iterator<org.csystem.generator.random.DoubleResult> generateDoubles(
        org.csystem.generator.random.DoublesGenerateInfo request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGenerateDoublesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *TODO
     * </pre>
     */
    public java.util.Iterator<org.csystem.generator.random.Int64Result> generateInt64s(
        org.csystem.generator.random.Int64sGenerateInfo request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGenerateInt64sMethod(), getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<org.csystem.generator.random.TextInfo> generateTextEN(
        org.csystem.generator.random.TextGenerateInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateTextENMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.csystem.generator.random.TextInfo> generateTextTR(
        org.csystem.generator.random.TextGenerateInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateTextTRMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.csystem.generator.random.TextBound> getTextBound(
        org.csystem.generator.random.NoParam request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTextBoundMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *TODO
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.csystem.generator.random.Int32Result> generateInt32(
        org.csystem.generator.random.Int32GenerateInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateInt32Method(), getCallOptions()), request);
    }

    /**
     * <pre>
     *TODO
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.csystem.generator.random.DoubleResult> generateDouble(
        org.csystem.generator.random.DoubleGenerateInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateDoubleMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *TODO
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.csystem.generator.random.Int64Result> generateInt64(
        org.csystem.generator.random.Int64GenerateInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateInt64Method(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GENERATE_TEXT_EN = 0;
  private static final int METHODID_GENERATE_TEXT_TR = 1;
  private static final int METHODID_GENERATE_TEXTS_EN = 2;
  private static final int METHODID_GENERATE_TEXTS_TR = 3;
  private static final int METHODID_GET_TEXT_BOUND = 4;
  private static final int METHODID_GENERATE_INT32 = 5;
  private static final int METHODID_GENERATE_DOUBLE = 6;
  private static final int METHODID_GENERATE_INT64 = 7;
  private static final int METHODID_GENERATE_INT32S = 8;
  private static final int METHODID_GENERATE_DOUBLES = 9;
  private static final int METHODID_GENERATE_INT64S = 10;
  private static final int METHODID_GENERATE_AND_JOIN_TEXTS_EN = 11;
  private static final int METHODID_GENERATE_AND_JOIN_TEXTS_TR = 12;
  private static final int METHODID_GENERATE_MULTIPLE_TEXTS_EN = 13;
  private static final int METHODID_GENERATE_MULTIPLE_TEXTS_TR = 14;

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
          serviceImpl.generateTextEN((org.csystem.generator.random.TextGenerateInfo) request,
              (io.grpc.stub.StreamObserver<org.csystem.generator.random.TextInfo>) responseObserver);
          break;
        case METHODID_GENERATE_TEXT_TR:
          serviceImpl.generateTextTR((org.csystem.generator.random.TextGenerateInfo) request,
              (io.grpc.stub.StreamObserver<org.csystem.generator.random.TextInfo>) responseObserver);
          break;
        case METHODID_GENERATE_TEXTS_EN:
          serviceImpl.generateTextsEN((org.csystem.generator.random.TextsGenerateInfo) request,
              (io.grpc.stub.StreamObserver<org.csystem.generator.random.TextInfo>) responseObserver);
          break;
        case METHODID_GENERATE_TEXTS_TR:
          serviceImpl.generateTextsTR((org.csystem.generator.random.TextsGenerateInfo) request,
              (io.grpc.stub.StreamObserver<org.csystem.generator.random.TextInfo>) responseObserver);
          break;
        case METHODID_GET_TEXT_BOUND:
          serviceImpl.getTextBound((org.csystem.generator.random.NoParam) request,
              (io.grpc.stub.StreamObserver<org.csystem.generator.random.TextBound>) responseObserver);
          break;
        case METHODID_GENERATE_INT32:
          serviceImpl.generateInt32((org.csystem.generator.random.Int32GenerateInfo) request,
              (io.grpc.stub.StreamObserver<org.csystem.generator.random.Int32Result>) responseObserver);
          break;
        case METHODID_GENERATE_DOUBLE:
          serviceImpl.generateDouble((org.csystem.generator.random.DoubleGenerateInfo) request,
              (io.grpc.stub.StreamObserver<org.csystem.generator.random.DoubleResult>) responseObserver);
          break;
        case METHODID_GENERATE_INT64:
          serviceImpl.generateInt64((org.csystem.generator.random.Int64GenerateInfo) request,
              (io.grpc.stub.StreamObserver<org.csystem.generator.random.Int64Result>) responseObserver);
          break;
        case METHODID_GENERATE_INT32S:
          serviceImpl.generateInt32s((org.csystem.generator.random.Int32sGenerateInfo) request,
              (io.grpc.stub.StreamObserver<org.csystem.generator.random.Int32Result>) responseObserver);
          break;
        case METHODID_GENERATE_DOUBLES:
          serviceImpl.generateDoubles((org.csystem.generator.random.DoublesGenerateInfo) request,
              (io.grpc.stub.StreamObserver<org.csystem.generator.random.DoubleResult>) responseObserver);
          break;
        case METHODID_GENERATE_INT64S:
          serviceImpl.generateInt64s((org.csystem.generator.random.Int64sGenerateInfo) request,
              (io.grpc.stub.StreamObserver<org.csystem.generator.random.Int64Result>) responseObserver);
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
        case METHODID_GENERATE_AND_JOIN_TEXTS_EN:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.generateAndJoinTextsEN(
              (io.grpc.stub.StreamObserver<org.csystem.generator.random.TextInfo>) responseObserver);
        case METHODID_GENERATE_AND_JOIN_TEXTS_TR:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.generateAndJoinTextsTR(
              (io.grpc.stub.StreamObserver<org.csystem.generator.random.TextInfo>) responseObserver);
        case METHODID_GENERATE_MULTIPLE_TEXTS_EN:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.generateMultipleTextsEN(
              (io.grpc.stub.StreamObserver<org.csystem.generator.random.TextInfo>) responseObserver);
        case METHODID_GENERATE_MULTIPLE_TEXTS_TR:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.generateMultipleTextsTR(
              (io.grpc.stub.StreamObserver<org.csystem.generator.random.TextInfo>) responseObserver);
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
      return org.csystem.generator.random.Randomgenerator.getDescriptor();
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
              .addMethod(getGenerateTextsENMethod())
              .addMethod(getGenerateTextsTRMethod())
              .addMethod(getGenerateAndJoinTextsENMethod())
              .addMethod(getGenerateAndJoinTextsTRMethod())
              .addMethod(getGenerateMultipleTextsENMethod())
              .addMethod(getGenerateMultipleTextsTRMethod())
              .addMethod(getGetTextBoundMethod())
              .addMethod(getGenerateInt32Method())
              .addMethod(getGenerateDoubleMethod())
              .addMethod(getGenerateInt64Method())
              .addMethod(getGenerateInt32sMethod())
              .addMethod(getGenerateDoublesMethod())
              .addMethod(getGenerateInt64sMethod())
              .build();
        }
      }
    }
    return result;
  }
}
