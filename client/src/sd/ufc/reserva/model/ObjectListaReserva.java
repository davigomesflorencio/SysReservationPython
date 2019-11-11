// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ListaReserva.proto

package sd.ufc.reserva.model;

public final class ObjectListaReserva {
  private ObjectListaReserva() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface ListaReservaOrBuilder extends
      // @@protoc_insertion_point(interface_extends:proto.ListaReserva)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>repeated .proto.Reserva reservas = 1;</code>
     */
    java.util.List<sd.ufc.reserva.model.ObjectReserva.Reserva> 
        getReservasList();
    /**
     * <code>repeated .proto.Reserva reservas = 1;</code>
     */
    sd.ufc.reserva.model.ObjectReserva.Reserva getReservas(int index);
    /**
     * <code>repeated .proto.Reserva reservas = 1;</code>
     */
    int getReservasCount();
    /**
     * <code>repeated .proto.Reserva reservas = 1;</code>
     */
    java.util.List<? extends sd.ufc.reserva.model.ObjectReserva.ReservaOrBuilder> 
        getReservasOrBuilderList();
    /**
     * <code>repeated .proto.Reserva reservas = 1;</code>
     */
    sd.ufc.reserva.model.ObjectReserva.ReservaOrBuilder getReservasOrBuilder(
        int index);
  }
  /**
   * Protobuf type {@code proto.ListaReserva}
   */
  public  static final class ListaReserva extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:proto.ListaReserva)
      ListaReservaOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use ListaReserva.newBuilder() to construct.
    private ListaReserva(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private ListaReserva() {
      reservas_ = java.util.Collections.emptyList();
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new ListaReserva();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private ListaReserva(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      int mutable_bitField0_ = 0;
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
            case 10: {
              if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                reservas_ = new java.util.ArrayList<sd.ufc.reserva.model.ObjectReserva.Reserva>();
                mutable_bitField0_ |= 0x00000001;
              }
              reservas_.add(
                  input.readMessage(sd.ufc.reserva.model.ObjectReserva.Reserva.parser(), extensionRegistry));
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
        if (((mutable_bitField0_ & 0x00000001) != 0)) {
          reservas_ = java.util.Collections.unmodifiableList(reservas_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return sd.ufc.reserva.model.ObjectListaReserva.internal_static_proto_ListaReserva_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return sd.ufc.reserva.model.ObjectListaReserva.internal_static_proto_ListaReserva_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              sd.ufc.reserva.model.ObjectListaReserva.ListaReserva.class, sd.ufc.reserva.model.ObjectListaReserva.ListaReserva.Builder.class);
    }

    public static final int RESERVAS_FIELD_NUMBER = 1;
    private java.util.List<sd.ufc.reserva.model.ObjectReserva.Reserva> reservas_;
    /**
     * <code>repeated .proto.Reserva reservas = 1;</code>
     */
    public java.util.List<sd.ufc.reserva.model.ObjectReserva.Reserva> getReservasList() {
      return reservas_;
    }
    /**
     * <code>repeated .proto.Reserva reservas = 1;</code>
     */
    public java.util.List<? extends sd.ufc.reserva.model.ObjectReserva.ReservaOrBuilder> 
        getReservasOrBuilderList() {
      return reservas_;
    }
    /**
     * <code>repeated .proto.Reserva reservas = 1;</code>
     */
    public int getReservasCount() {
      return reservas_.size();
    }
    /**
     * <code>repeated .proto.Reserva reservas = 1;</code>
     */
    public sd.ufc.reserva.model.ObjectReserva.Reserva getReservas(int index) {
      return reservas_.get(index);
    }
    /**
     * <code>repeated .proto.Reserva reservas = 1;</code>
     */
    public sd.ufc.reserva.model.ObjectReserva.ReservaOrBuilder getReservasOrBuilder(
        int index) {
      return reservas_.get(index);
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
      for (int i = 0; i < reservas_.size(); i++) {
        output.writeMessage(1, reservas_.get(i));
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      for (int i = 0; i < reservas_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(1, reservas_.get(i));
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
      if (!(obj instanceof sd.ufc.reserva.model.ObjectListaReserva.ListaReserva)) {
        return super.equals(obj);
      }
      sd.ufc.reserva.model.ObjectListaReserva.ListaReserva other = (sd.ufc.reserva.model.ObjectListaReserva.ListaReserva) obj;

      if (!getReservasList()
          .equals(other.getReservasList())) return false;
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
      if (getReservasCount() > 0) {
        hash = (37 * hash) + RESERVAS_FIELD_NUMBER;
        hash = (53 * hash) + getReservasList().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static sd.ufc.reserva.model.ObjectListaReserva.ListaReserva parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static sd.ufc.reserva.model.ObjectListaReserva.ListaReserva parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static sd.ufc.reserva.model.ObjectListaReserva.ListaReserva parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static sd.ufc.reserva.model.ObjectListaReserva.ListaReserva parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static sd.ufc.reserva.model.ObjectListaReserva.ListaReserva parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static sd.ufc.reserva.model.ObjectListaReserva.ListaReserva parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static sd.ufc.reserva.model.ObjectListaReserva.ListaReserva parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static sd.ufc.reserva.model.ObjectListaReserva.ListaReserva parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static sd.ufc.reserva.model.ObjectListaReserva.ListaReserva parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static sd.ufc.reserva.model.ObjectListaReserva.ListaReserva parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static sd.ufc.reserva.model.ObjectListaReserva.ListaReserva parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static sd.ufc.reserva.model.ObjectListaReserva.ListaReserva parseFrom(
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
    public static Builder newBuilder(sd.ufc.reserva.model.ObjectListaReserva.ListaReserva prototype) {
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
     * Protobuf type {@code proto.ListaReserva}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:proto.ListaReserva)
        sd.ufc.reserva.model.ObjectListaReserva.ListaReservaOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return sd.ufc.reserva.model.ObjectListaReserva.internal_static_proto_ListaReserva_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return sd.ufc.reserva.model.ObjectListaReserva.internal_static_proto_ListaReserva_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                sd.ufc.reserva.model.ObjectListaReserva.ListaReserva.class, sd.ufc.reserva.model.ObjectListaReserva.ListaReserva.Builder.class);
      }

      // Construct using sd.ufc.reserva.model.ObjectListaReserva.ListaReserva.newBuilder()
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
          getReservasFieldBuilder();
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        if (reservasBuilder_ == null) {
          reservas_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          reservasBuilder_.clear();
        }
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return sd.ufc.reserva.model.ObjectListaReserva.internal_static_proto_ListaReserva_descriptor;
      }

      @java.lang.Override
      public sd.ufc.reserva.model.ObjectListaReserva.ListaReserva getDefaultInstanceForType() {
        return sd.ufc.reserva.model.ObjectListaReserva.ListaReserva.getDefaultInstance();
      }

      @java.lang.Override
      public sd.ufc.reserva.model.ObjectListaReserva.ListaReserva build() {
        sd.ufc.reserva.model.ObjectListaReserva.ListaReserva result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public sd.ufc.reserva.model.ObjectListaReserva.ListaReserva buildPartial() {
        sd.ufc.reserva.model.ObjectListaReserva.ListaReserva result = new sd.ufc.reserva.model.ObjectListaReserva.ListaReserva(this);
        int from_bitField0_ = bitField0_;
        if (reservasBuilder_ == null) {
          if (((bitField0_ & 0x00000001) != 0)) {
            reservas_ = java.util.Collections.unmodifiableList(reservas_);
            bitField0_ = (bitField0_ & ~0x00000001);
          }
          result.reservas_ = reservas_;
        } else {
          result.reservas_ = reservasBuilder_.build();
        }
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
        if (other instanceof sd.ufc.reserva.model.ObjectListaReserva.ListaReserva) {
          return mergeFrom((sd.ufc.reserva.model.ObjectListaReserva.ListaReserva)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(sd.ufc.reserva.model.ObjectListaReserva.ListaReserva other) {
        if (other == sd.ufc.reserva.model.ObjectListaReserva.ListaReserva.getDefaultInstance()) return this;
        if (reservasBuilder_ == null) {
          if (!other.reservas_.isEmpty()) {
            if (reservas_.isEmpty()) {
              reservas_ = other.reservas_;
              bitField0_ = (bitField0_ & ~0x00000001);
            } else {
              ensureReservasIsMutable();
              reservas_.addAll(other.reservas_);
            }
            onChanged();
          }
        } else {
          if (!other.reservas_.isEmpty()) {
            if (reservasBuilder_.isEmpty()) {
              reservasBuilder_.dispose();
              reservasBuilder_ = null;
              reservas_ = other.reservas_;
              bitField0_ = (bitField0_ & ~0x00000001);
              reservasBuilder_ = 
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                   getReservasFieldBuilder() : null;
            } else {
              reservasBuilder_.addAllMessages(other.reservas_);
            }
          }
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
        sd.ufc.reserva.model.ObjectListaReserva.ListaReserva parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (sd.ufc.reserva.model.ObjectListaReserva.ListaReserva) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private java.util.List<sd.ufc.reserva.model.ObjectReserva.Reserva> reservas_ =
        java.util.Collections.emptyList();
      private void ensureReservasIsMutable() {
        if (!((bitField0_ & 0x00000001) != 0)) {
          reservas_ = new java.util.ArrayList<sd.ufc.reserva.model.ObjectReserva.Reserva>(reservas_);
          bitField0_ |= 0x00000001;
         }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
          sd.ufc.reserva.model.ObjectReserva.Reserva, sd.ufc.reserva.model.ObjectReserva.Reserva.Builder, sd.ufc.reserva.model.ObjectReserva.ReservaOrBuilder> reservasBuilder_;

      /**
       * <code>repeated .proto.Reserva reservas = 1;</code>
       */
      public java.util.List<sd.ufc.reserva.model.ObjectReserva.Reserva> getReservasList() {
        if (reservasBuilder_ == null) {
          return java.util.Collections.unmodifiableList(reservas_);
        } else {
          return reservasBuilder_.getMessageList();
        }
      }
      /**
       * <code>repeated .proto.Reserva reservas = 1;</code>
       */
      public int getReservasCount() {
        if (reservasBuilder_ == null) {
          return reservas_.size();
        } else {
          return reservasBuilder_.getCount();
        }
      }
      /**
       * <code>repeated .proto.Reserva reservas = 1;</code>
       */
      public sd.ufc.reserva.model.ObjectReserva.Reserva getReservas(int index) {
        if (reservasBuilder_ == null) {
          return reservas_.get(index);
        } else {
          return reservasBuilder_.getMessage(index);
        }
      }
      /**
       * <code>repeated .proto.Reserva reservas = 1;</code>
       */
      public Builder setReservas(
          int index, sd.ufc.reserva.model.ObjectReserva.Reserva value) {
        if (reservasBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureReservasIsMutable();
          reservas_.set(index, value);
          onChanged();
        } else {
          reservasBuilder_.setMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .proto.Reserva reservas = 1;</code>
       */
      public Builder setReservas(
          int index, sd.ufc.reserva.model.ObjectReserva.Reserva.Builder builderForValue) {
        if (reservasBuilder_ == null) {
          ensureReservasIsMutable();
          reservas_.set(index, builderForValue.build());
          onChanged();
        } else {
          reservasBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .proto.Reserva reservas = 1;</code>
       */
      public Builder addReservas(sd.ufc.reserva.model.ObjectReserva.Reserva value) {
        if (reservasBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureReservasIsMutable();
          reservas_.add(value);
          onChanged();
        } else {
          reservasBuilder_.addMessage(value);
        }
        return this;
      }
      /**
       * <code>repeated .proto.Reserva reservas = 1;</code>
       */
      public Builder addReservas(
          int index, sd.ufc.reserva.model.ObjectReserva.Reserva value) {
        if (reservasBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureReservasIsMutable();
          reservas_.add(index, value);
          onChanged();
        } else {
          reservasBuilder_.addMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .proto.Reserva reservas = 1;</code>
       */
      public Builder addReservas(
          sd.ufc.reserva.model.ObjectReserva.Reserva.Builder builderForValue) {
        if (reservasBuilder_ == null) {
          ensureReservasIsMutable();
          reservas_.add(builderForValue.build());
          onChanged();
        } else {
          reservasBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .proto.Reserva reservas = 1;</code>
       */
      public Builder addReservas(
          int index, sd.ufc.reserva.model.ObjectReserva.Reserva.Builder builderForValue) {
        if (reservasBuilder_ == null) {
          ensureReservasIsMutable();
          reservas_.add(index, builderForValue.build());
          onChanged();
        } else {
          reservasBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .proto.Reserva reservas = 1;</code>
       */
      public Builder addAllReservas(
          java.lang.Iterable<? extends sd.ufc.reserva.model.ObjectReserva.Reserva> values) {
        if (reservasBuilder_ == null) {
          ensureReservasIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(
              values, reservas_);
          onChanged();
        } else {
          reservasBuilder_.addAllMessages(values);
        }
        return this;
      }
      /**
       * <code>repeated .proto.Reserva reservas = 1;</code>
       */
      public Builder clearReservas() {
        if (reservasBuilder_ == null) {
          reservas_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
          onChanged();
        } else {
          reservasBuilder_.clear();
        }
        return this;
      }
      /**
       * <code>repeated .proto.Reserva reservas = 1;</code>
       */
      public Builder removeReservas(int index) {
        if (reservasBuilder_ == null) {
          ensureReservasIsMutable();
          reservas_.remove(index);
          onChanged();
        } else {
          reservasBuilder_.remove(index);
        }
        return this;
      }
      /**
       * <code>repeated .proto.Reserva reservas = 1;</code>
       */
      public sd.ufc.reserva.model.ObjectReserva.Reserva.Builder getReservasBuilder(
          int index) {
        return getReservasFieldBuilder().getBuilder(index);
      }
      /**
       * <code>repeated .proto.Reserva reservas = 1;</code>
       */
      public sd.ufc.reserva.model.ObjectReserva.ReservaOrBuilder getReservasOrBuilder(
          int index) {
        if (reservasBuilder_ == null) {
          return reservas_.get(index);  } else {
          return reservasBuilder_.getMessageOrBuilder(index);
        }
      }
      /**
       * <code>repeated .proto.Reserva reservas = 1;</code>
       */
      public java.util.List<? extends sd.ufc.reserva.model.ObjectReserva.ReservaOrBuilder> 
           getReservasOrBuilderList() {
        if (reservasBuilder_ != null) {
          return reservasBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(reservas_);
        }
      }
      /**
       * <code>repeated .proto.Reserva reservas = 1;</code>
       */
      public sd.ufc.reserva.model.ObjectReserva.Reserva.Builder addReservasBuilder() {
        return getReservasFieldBuilder().addBuilder(
            sd.ufc.reserva.model.ObjectReserva.Reserva.getDefaultInstance());
      }
      /**
       * <code>repeated .proto.Reserva reservas = 1;</code>
       */
      public sd.ufc.reserva.model.ObjectReserva.Reserva.Builder addReservasBuilder(
          int index) {
        return getReservasFieldBuilder().addBuilder(
            index, sd.ufc.reserva.model.ObjectReserva.Reserva.getDefaultInstance());
      }
      /**
       * <code>repeated .proto.Reserva reservas = 1;</code>
       */
      public java.util.List<sd.ufc.reserva.model.ObjectReserva.Reserva.Builder> 
           getReservasBuilderList() {
        return getReservasFieldBuilder().getBuilderList();
      }
      private com.google.protobuf.RepeatedFieldBuilderV3<
          sd.ufc.reserva.model.ObjectReserva.Reserva, sd.ufc.reserva.model.ObjectReserva.Reserva.Builder, sd.ufc.reserva.model.ObjectReserva.ReservaOrBuilder> 
          getReservasFieldBuilder() {
        if (reservasBuilder_ == null) {
          reservasBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
              sd.ufc.reserva.model.ObjectReserva.Reserva, sd.ufc.reserva.model.ObjectReserva.Reserva.Builder, sd.ufc.reserva.model.ObjectReserva.ReservaOrBuilder>(
                  reservas_,
                  ((bitField0_ & 0x00000001) != 0),
                  getParentForChildren(),
                  isClean());
          reservas_ = null;
        }
        return reservasBuilder_;
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


      // @@protoc_insertion_point(builder_scope:proto.ListaReserva)
    }

    // @@protoc_insertion_point(class_scope:proto.ListaReserva)
    private static final sd.ufc.reserva.model.ObjectListaReserva.ListaReserva DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new sd.ufc.reserva.model.ObjectListaReserva.ListaReserva();
    }

    public static sd.ufc.reserva.model.ObjectListaReserva.ListaReserva getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<ListaReserva>
        PARSER = new com.google.protobuf.AbstractParser<ListaReserva>() {
      @java.lang.Override
      public ListaReserva parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new ListaReserva(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<ListaReserva> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<ListaReserva> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public sd.ufc.reserva.model.ObjectListaReserva.ListaReserva getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_proto_ListaReserva_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_proto_ListaReserva_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\022ListaReserva.proto\022\005proto\032\rReserva.pro" +
      "to\"0\n\014ListaReserva\022 \n\010reservas\030\001 \003(\0132\016.p" +
      "roto.ReservaB*\n\024sd.ufc.reserva.modelB\022Ob" +
      "jectListaReservab\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          sd.ufc.reserva.model.ObjectReserva.getDescriptor(),
        });
    internal_static_proto_ListaReserva_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_proto_ListaReserva_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_proto_ListaReserva_descriptor,
        new java.lang.String[] { "Reservas", });
    sd.ufc.reserva.model.ObjectReserva.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
