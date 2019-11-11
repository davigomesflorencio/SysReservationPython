// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/Mensagem.proto

package sd.ufc.reserva.model;

public final class ObjectMensagem {
  private ObjectMensagem() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface MensagemOrBuilder extends
      // @@protoc_insertion_point(interface_extends:proto.Mensagem)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int32 messageType = 1;</code>
     * @return The messageType.
     */
    int getMessageType();

    /**
     * <code>int32 request_id = 2;</code>
     * @return The requestId.
     */
    int getRequestId();

    /**
     * <code>string object_reference = 3;</code>
     * @return The objectReference.
     */
    java.lang.String getObjectReference();
    /**
     * <code>string object_reference = 3;</code>
     * @return The bytes for objectReference.
     */
    com.google.protobuf.ByteString
        getObjectReferenceBytes();

    /**
     * <code>string method = 4;</code>
     * @return The method.
     */
    java.lang.String getMethod();
    /**
     * <code>string method = 4;</code>
     * @return The bytes for method.
     */
    com.google.protobuf.ByteString
        getMethodBytes();

    /**
     * <code>bytes arguments = 5;</code>
     * @return The arguments.
     */
    com.google.protobuf.ByteString getArguments();
  }
  /**
   * Protobuf type {@code proto.Mensagem}
   */
  public  static final class Mensagem extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:proto.Mensagem)
      MensagemOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use Mensagem.newBuilder() to construct.
    private Mensagem(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Mensagem() {
      objectReference_ = "";
      method_ = "";
      arguments_ = com.google.protobuf.ByteString.EMPTY;
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new Mensagem();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private Mensagem(
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

              messageType_ = input.readInt32();
              break;
            }
            case 16: {

              requestId_ = input.readInt32();
              break;
            }
            case 26: {
              java.lang.String s = input.readStringRequireUtf8();

              objectReference_ = s;
              break;
            }
            case 34: {
              java.lang.String s = input.readStringRequireUtf8();

              method_ = s;
              break;
            }
            case 42: {

              arguments_ = input.readBytes();
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
      return sd.ufc.reserva.model.ObjectMensagem.internal_static_proto_Mensagem_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return sd.ufc.reserva.model.ObjectMensagem.internal_static_proto_Mensagem_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              sd.ufc.reserva.model.ObjectMensagem.Mensagem.class, sd.ufc.reserva.model.ObjectMensagem.Mensagem.Builder.class);
    }

    public static final int MESSAGETYPE_FIELD_NUMBER = 1;
    private int messageType_;
    /**
     * <code>int32 messageType = 1;</code>
     * @return The messageType.
     */
    public int getMessageType() {
      return messageType_;
    }

    public static final int REQUEST_ID_FIELD_NUMBER = 2;
    private int requestId_;
    /**
     * <code>int32 request_id = 2;</code>
     * @return The requestId.
     */
    public int getRequestId() {
      return requestId_;
    }

    public static final int OBJECT_REFERENCE_FIELD_NUMBER = 3;
    private volatile java.lang.Object objectReference_;
    /**
     * <code>string object_reference = 3;</code>
     * @return The objectReference.
     */
    public java.lang.String getObjectReference() {
      java.lang.Object ref = objectReference_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        objectReference_ = s;
        return s;
      }
    }
    /**
     * <code>string object_reference = 3;</code>
     * @return The bytes for objectReference.
     */
    public com.google.protobuf.ByteString
        getObjectReferenceBytes() {
      java.lang.Object ref = objectReference_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        objectReference_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int METHOD_FIELD_NUMBER = 4;
    private volatile java.lang.Object method_;
    /**
     * <code>string method = 4;</code>
     * @return The method.
     */
    public java.lang.String getMethod() {
      java.lang.Object ref = method_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        method_ = s;
        return s;
      }
    }
    /**
     * <code>string method = 4;</code>
     * @return The bytes for method.
     */
    public com.google.protobuf.ByteString
        getMethodBytes() {
      java.lang.Object ref = method_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        method_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int ARGUMENTS_FIELD_NUMBER = 5;
    private com.google.protobuf.ByteString arguments_;
    /**
     * <code>bytes arguments = 5;</code>
     * @return The arguments.
     */
    public com.google.protobuf.ByteString getArguments() {
      return arguments_;
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
      if (messageType_ != 0) {
        output.writeInt32(1, messageType_);
      }
      if (requestId_ != 0) {
        output.writeInt32(2, requestId_);
      }
      if (!getObjectReferenceBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, objectReference_);
      }
      if (!getMethodBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 4, method_);
      }
      if (!arguments_.isEmpty()) {
        output.writeBytes(5, arguments_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (messageType_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, messageType_);
      }
      if (requestId_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(2, requestId_);
      }
      if (!getObjectReferenceBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, objectReference_);
      }
      if (!getMethodBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, method_);
      }
      if (!arguments_.isEmpty()) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(5, arguments_);
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
      if (!(obj instanceof sd.ufc.reserva.model.ObjectMensagem.Mensagem)) {
        return super.equals(obj);
      }
      sd.ufc.reserva.model.ObjectMensagem.Mensagem other = (sd.ufc.reserva.model.ObjectMensagem.Mensagem) obj;

      if (getMessageType()
          != other.getMessageType()) return false;
      if (getRequestId()
          != other.getRequestId()) return false;
      if (!getObjectReference()
          .equals(other.getObjectReference())) return false;
      if (!getMethod()
          .equals(other.getMethod())) return false;
      if (!getArguments()
          .equals(other.getArguments())) return false;
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
      hash = (37 * hash) + MESSAGETYPE_FIELD_NUMBER;
      hash = (53 * hash) + getMessageType();
      hash = (37 * hash) + REQUEST_ID_FIELD_NUMBER;
      hash = (53 * hash) + getRequestId();
      hash = (37 * hash) + OBJECT_REFERENCE_FIELD_NUMBER;
      hash = (53 * hash) + getObjectReference().hashCode();
      hash = (37 * hash) + METHOD_FIELD_NUMBER;
      hash = (53 * hash) + getMethod().hashCode();
      hash = (37 * hash) + ARGUMENTS_FIELD_NUMBER;
      hash = (53 * hash) + getArguments().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static sd.ufc.reserva.model.ObjectMensagem.Mensagem parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static sd.ufc.reserva.model.ObjectMensagem.Mensagem parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static sd.ufc.reserva.model.ObjectMensagem.Mensagem parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static sd.ufc.reserva.model.ObjectMensagem.Mensagem parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static sd.ufc.reserva.model.ObjectMensagem.Mensagem parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static sd.ufc.reserva.model.ObjectMensagem.Mensagem parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static sd.ufc.reserva.model.ObjectMensagem.Mensagem parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static sd.ufc.reserva.model.ObjectMensagem.Mensagem parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static sd.ufc.reserva.model.ObjectMensagem.Mensagem parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static sd.ufc.reserva.model.ObjectMensagem.Mensagem parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static sd.ufc.reserva.model.ObjectMensagem.Mensagem parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static sd.ufc.reserva.model.ObjectMensagem.Mensagem parseFrom(
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
    public static Builder newBuilder(sd.ufc.reserva.model.ObjectMensagem.Mensagem prototype) {
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
     * Protobuf type {@code proto.Mensagem}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:proto.Mensagem)
        sd.ufc.reserva.model.ObjectMensagem.MensagemOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return sd.ufc.reserva.model.ObjectMensagem.internal_static_proto_Mensagem_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return sd.ufc.reserva.model.ObjectMensagem.internal_static_proto_Mensagem_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                sd.ufc.reserva.model.ObjectMensagem.Mensagem.class, sd.ufc.reserva.model.ObjectMensagem.Mensagem.Builder.class);
      }

      // Construct using sd.ufc.reserva.model.ObjectMensagem.Mensagem.newBuilder()
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
        messageType_ = 0;

        requestId_ = 0;

        objectReference_ = "";

        method_ = "";

        arguments_ = com.google.protobuf.ByteString.EMPTY;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return sd.ufc.reserva.model.ObjectMensagem.internal_static_proto_Mensagem_descriptor;
      }

      @java.lang.Override
      public sd.ufc.reserva.model.ObjectMensagem.Mensagem getDefaultInstanceForType() {
        return sd.ufc.reserva.model.ObjectMensagem.Mensagem.getDefaultInstance();
      }

      @java.lang.Override
      public sd.ufc.reserva.model.ObjectMensagem.Mensagem build() {
        sd.ufc.reserva.model.ObjectMensagem.Mensagem result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public sd.ufc.reserva.model.ObjectMensagem.Mensagem buildPartial() {
        sd.ufc.reserva.model.ObjectMensagem.Mensagem result = new sd.ufc.reserva.model.ObjectMensagem.Mensagem(this);
        result.messageType_ = messageType_;
        result.requestId_ = requestId_;
        result.objectReference_ = objectReference_;
        result.method_ = method_;
        result.arguments_ = arguments_;
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
        if (other instanceof sd.ufc.reserva.model.ObjectMensagem.Mensagem) {
          return mergeFrom((sd.ufc.reserva.model.ObjectMensagem.Mensagem)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(sd.ufc.reserva.model.ObjectMensagem.Mensagem other) {
        if (other == sd.ufc.reserva.model.ObjectMensagem.Mensagem.getDefaultInstance()) return this;
        if (other.getMessageType() != 0) {
          setMessageType(other.getMessageType());
        }
        if (other.getRequestId() != 0) {
          setRequestId(other.getRequestId());
        }
        if (!other.getObjectReference().isEmpty()) {
          objectReference_ = other.objectReference_;
          onChanged();
        }
        if (!other.getMethod().isEmpty()) {
          method_ = other.method_;
          onChanged();
        }
        if (other.getArguments() != com.google.protobuf.ByteString.EMPTY) {
          setArguments(other.getArguments());
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
        sd.ufc.reserva.model.ObjectMensagem.Mensagem parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (sd.ufc.reserva.model.ObjectMensagem.Mensagem) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int messageType_ ;
      /**
       * <code>int32 messageType = 1;</code>
       * @return The messageType.
       */
      public int getMessageType() {
        return messageType_;
      }
      /**
       * <code>int32 messageType = 1;</code>
       * @param value The messageType to set.
       * @return This builder for chaining.
       */
      public Builder setMessageType(int value) {
        
        messageType_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 messageType = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearMessageType() {
        
        messageType_ = 0;
        onChanged();
        return this;
      }

      private int requestId_ ;
      /**
       * <code>int32 request_id = 2;</code>
       * @return The requestId.
       */
      public int getRequestId() {
        return requestId_;
      }
      /**
       * <code>int32 request_id = 2;</code>
       * @param value The requestId to set.
       * @return This builder for chaining.
       */
      public Builder setRequestId(int value) {
        
        requestId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 request_id = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearRequestId() {
        
        requestId_ = 0;
        onChanged();
        return this;
      }

      private java.lang.Object objectReference_ = "";
      /**
       * <code>string object_reference = 3;</code>
       * @return The objectReference.
       */
      public java.lang.String getObjectReference() {
        java.lang.Object ref = objectReference_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          objectReference_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string object_reference = 3;</code>
       * @return The bytes for objectReference.
       */
      public com.google.protobuf.ByteString
          getObjectReferenceBytes() {
        java.lang.Object ref = objectReference_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          objectReference_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string object_reference = 3;</code>
       * @param value The objectReference to set.
       * @return This builder for chaining.
       */
      public Builder setObjectReference(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        objectReference_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string object_reference = 3;</code>
       * @return This builder for chaining.
       */
      public Builder clearObjectReference() {
        
        objectReference_ = getDefaultInstance().getObjectReference();
        onChanged();
        return this;
      }
      /**
       * <code>string object_reference = 3;</code>
       * @param value The bytes for objectReference to set.
       * @return This builder for chaining.
       */
      public Builder setObjectReferenceBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        objectReference_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object method_ = "";
      /**
       * <code>string method = 4;</code>
       * @return The method.
       */
      public java.lang.String getMethod() {
        java.lang.Object ref = method_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          method_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string method = 4;</code>
       * @return The bytes for method.
       */
      public com.google.protobuf.ByteString
          getMethodBytes() {
        java.lang.Object ref = method_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          method_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string method = 4;</code>
       * @param value The method to set.
       * @return This builder for chaining.
       */
      public Builder setMethod(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        method_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string method = 4;</code>
       * @return This builder for chaining.
       */
      public Builder clearMethod() {
        
        method_ = getDefaultInstance().getMethod();
        onChanged();
        return this;
      }
      /**
       * <code>string method = 4;</code>
       * @param value The bytes for method to set.
       * @return This builder for chaining.
       */
      public Builder setMethodBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        method_ = value;
        onChanged();
        return this;
      }

      private com.google.protobuf.ByteString arguments_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>bytes arguments = 5;</code>
       * @return The arguments.
       */
      public com.google.protobuf.ByteString getArguments() {
        return arguments_;
      }
      /**
       * <code>bytes arguments = 5;</code>
       * @param value The arguments to set.
       * @return This builder for chaining.
       */
      public Builder setArguments(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        arguments_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bytes arguments = 5;</code>
       * @return This builder for chaining.
       */
      public Builder clearArguments() {
        
        arguments_ = getDefaultInstance().getArguments();
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


      // @@protoc_insertion_point(builder_scope:proto.Mensagem)
    }

    // @@protoc_insertion_point(class_scope:proto.Mensagem)
    private static final sd.ufc.reserva.model.ObjectMensagem.Mensagem DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new sd.ufc.reserva.model.ObjectMensagem.Mensagem();
    }

    public static sd.ufc.reserva.model.ObjectMensagem.Mensagem getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Mensagem>
        PARSER = new com.google.protobuf.AbstractParser<Mensagem>() {
      @java.lang.Override
      public Mensagem parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new Mensagem(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Mensagem> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Mensagem> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public sd.ufc.reserva.model.ObjectMensagem.Mensagem getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_proto_Mensagem_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_proto_Mensagem_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\024proto/Mensagem.proto\022\005proto\"p\n\010Mensage" +
      "m\022\023\n\013messageType\030\001 \001(\005\022\022\n\nrequest_id\030\002 \001" +
      "(\005\022\030\n\020object_reference\030\003 \001(\t\022\016\n\006method\030\004" +
      " \001(\t\022\021\n\targuments\030\005 \001(\014B&\n\024sd.ufc.reserv" +
      "a.modelB\016ObjectMensagemb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_proto_Mensagem_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_proto_Mensagem_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_proto_Mensagem_descriptor,
        new java.lang.String[] { "MessageType", "RequestId", "ObjectReference", "Method", "Arguments", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
