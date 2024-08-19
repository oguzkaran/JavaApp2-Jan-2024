// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: randomgenerator.proto

package org.csystem.generator.random;

/**
 * Protobuf type {@code org.csystem.generator.random.Int64GenerateInfo}
 */
public final class Int64GenerateInfo extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:org.csystem.generator.random.Int64GenerateInfo)
    Int64GenerateInfoOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Int64GenerateInfo.newBuilder() to construct.
  private Int64GenerateInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Int64GenerateInfo() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Int64GenerateInfo();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Int64GenerateInfo(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            min_ = input.readSInt64();
            break;
          }
          case 16: {

            bound_ = input.readSInt64();
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.csystem.generator.random.Randomgenerator.internal_static_org_csystem_generator_random_Int64GenerateInfo_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.csystem.generator.random.Randomgenerator.internal_static_org_csystem_generator_random_Int64GenerateInfo_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.csystem.generator.random.Int64GenerateInfo.class, org.csystem.generator.random.Int64GenerateInfo.Builder.class);
  }

  public static final int MIN_FIELD_NUMBER = 1;
  private long min_;
  /**
   * <code>sint64 min = 1;</code>
   * @return The min.
   */
  @java.lang.Override
  public long getMin() {
    return min_;
  }

  public static final int BOUND_FIELD_NUMBER = 2;
  private long bound_;
  /**
   * <code>sint64 bound = 2;</code>
   * @return The bound.
   */
  @java.lang.Override
  public long getBound() {
    return bound_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (min_ != 0L) {
      output.writeSInt64(1, min_);
    }
    if (bound_ != 0L) {
      output.writeSInt64(2, bound_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (min_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeSInt64Size(1, min_);
    }
    if (bound_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeSInt64Size(2, bound_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof org.csystem.generator.random.Int64GenerateInfo)) {
      return super.equals(obj);
    }
    org.csystem.generator.random.Int64GenerateInfo other = (org.csystem.generator.random.Int64GenerateInfo) obj;

    if (getMin()
        != other.getMin()) return false;
    if (getBound()
        != other.getBound()) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + MIN_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getMin());
    hash = (37 * hash) + BOUND_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getBound());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.csystem.generator.random.Int64GenerateInfo parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.csystem.generator.random.Int64GenerateInfo parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.csystem.generator.random.Int64GenerateInfo parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.csystem.generator.random.Int64GenerateInfo parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.csystem.generator.random.Int64GenerateInfo parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.csystem.generator.random.Int64GenerateInfo parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.csystem.generator.random.Int64GenerateInfo parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.csystem.generator.random.Int64GenerateInfo parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.csystem.generator.random.Int64GenerateInfo parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.csystem.generator.random.Int64GenerateInfo parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.csystem.generator.random.Int64GenerateInfo parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.csystem.generator.random.Int64GenerateInfo parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(org.csystem.generator.random.Int64GenerateInfo prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code org.csystem.generator.random.Int64GenerateInfo}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:org.csystem.generator.random.Int64GenerateInfo)
      org.csystem.generator.random.Int64GenerateInfoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.csystem.generator.random.Randomgenerator.internal_static_org_csystem_generator_random_Int64GenerateInfo_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.csystem.generator.random.Randomgenerator.internal_static_org_csystem_generator_random_Int64GenerateInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.csystem.generator.random.Int64GenerateInfo.class, org.csystem.generator.random.Int64GenerateInfo.Builder.class);
    }

    // Construct using org.csystem.generator.random.Int64GenerateInfo.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      min_ = 0L;

      bound_ = 0L;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.csystem.generator.random.Randomgenerator.internal_static_org_csystem_generator_random_Int64GenerateInfo_descriptor;
    }

    @java.lang.Override
    public org.csystem.generator.random.Int64GenerateInfo getDefaultInstanceForType() {
      return org.csystem.generator.random.Int64GenerateInfo.getDefaultInstance();
    }

    @java.lang.Override
    public org.csystem.generator.random.Int64GenerateInfo build() {
      org.csystem.generator.random.Int64GenerateInfo result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.csystem.generator.random.Int64GenerateInfo buildPartial() {
      org.csystem.generator.random.Int64GenerateInfo result = new org.csystem.generator.random.Int64GenerateInfo(this);
      result.min_ = min_;
      result.bound_ = bound_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof org.csystem.generator.random.Int64GenerateInfo) {
        return mergeFrom((org.csystem.generator.random.Int64GenerateInfo)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.csystem.generator.random.Int64GenerateInfo other) {
      if (other == org.csystem.generator.random.Int64GenerateInfo.getDefaultInstance()) return this;
      if (other.getMin() != 0L) {
        setMin(other.getMin());
      }
      if (other.getBound() != 0L) {
        setBound(other.getBound());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      org.csystem.generator.random.Int64GenerateInfo parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.csystem.generator.random.Int64GenerateInfo) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private long min_ ;
    /**
     * <code>sint64 min = 1;</code>
     * @return The min.
     */
    @java.lang.Override
    public long getMin() {
      return min_;
    }
    /**
     * <code>sint64 min = 1;</code>
     * @param value The min to set.
     * @return This builder for chaining.
     */
    public Builder setMin(long value) {
      
      min_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>sint64 min = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearMin() {
      
      min_ = 0L;
      onChanged();
      return this;
    }

    private long bound_ ;
    /**
     * <code>sint64 bound = 2;</code>
     * @return The bound.
     */
    @java.lang.Override
    public long getBound() {
      return bound_;
    }
    /**
     * <code>sint64 bound = 2;</code>
     * @param value The bound to set.
     * @return This builder for chaining.
     */
    public Builder setBound(long value) {
      
      bound_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>sint64 bound = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearBound() {
      
      bound_ = 0L;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:org.csystem.generator.random.Int64GenerateInfo)
  }

  // @@protoc_insertion_point(class_scope:org.csystem.generator.random.Int64GenerateInfo)
  private static final org.csystem.generator.random.Int64GenerateInfo DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.csystem.generator.random.Int64GenerateInfo();
  }

  public static org.csystem.generator.random.Int64GenerateInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Int64GenerateInfo>
      PARSER = new com.google.protobuf.AbstractParser<Int64GenerateInfo>() {
    @java.lang.Override
    public Int64GenerateInfo parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Int64GenerateInfo(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Int64GenerateInfo> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Int64GenerateInfo> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.csystem.generator.random.Int64GenerateInfo getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
