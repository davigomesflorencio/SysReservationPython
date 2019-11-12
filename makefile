#
# Makefile to call protocol buffer compiler for Java/Python
#
CC          :=protoc

PROTO		:=./proto

MSG         :=./proto/Mensagem.proto
RESERVA		:=./proto/Reserva.proto
SALA		:=./proto/Sala.proto
LISTA_SALA	:=./proto/ListaSala.proto
LISTA_RESERVA :=./proto/ListaReserva.proto
AUTH_USUARIO	:=./proto/AuthUsuario.proto
CADASTRO_USUARIO :=./proto/CadastroUsuario.proto
IDENTIFICACAO :=./proto/Identificacao.proto
MESSAGE_RESPONSE :=./proto/MessageResponse.proto

PYTHON_OUT  :=./server/model
JAVA_OUT    :=./client/src

all: java py

java:usuario_java message_response_java msg_java sala_java reserva_java lista_reserva_java lista_sala_java cadastro_usuario_java identificacao_java

py:usuario_py message_response_py msg_py sala_py reserva_py lista_reserva_py lista_sala_py cadastro_usuario_py identificacao_py

# JAVA
msg_java:
	$(CC) $(MSG) --java_out=$(JAVA_OUT)
sala_java:
	$(CC) $(SALA) --java_out=$(JAVA_OUT)
lista_sala_java:
	$(CC) --proto_path=$(PROTO) $(LISTA_SALA) --java_out=$(JAVA_OUT)
reserva_java:
	$(CC) --proto_path=$(PROTO) $(RESERVA) --java_out=$(JAVA_OUT)
lista_reserva_java:
	$(CC) --proto_path=$(PROTO) $(LISTA_RESERVA) --java_out=$(JAVA_OUT)
usuario_java:
	$(CC) --proto_path=$(PROTO) $(AUTH_USUARIO) --java_out=$(JAVA_OUT)
cadastro_usuario_java:
	$(CC) $(CADASTRO_USUARIO) --java_out=$(JAVA_OUT)
identificacao_java:
	$(CC) $(IDENTIFICACAO) --java_out=$(JAVA_OUT)
message_response_java:
	$(CC) $(MESSAGE_RESPONSE) --java_out=$(JAVA_OUT)

# PYTHON
msg_py:
	$(CC) --proto_path=$(PROTO) $(MSG) --python_out=$(PYTHON_OUT)
sala_py:
	$(CC) --proto_path=$(PROTO) $(SALA) --python_out=$(PYTHON_OUT)
lista_sala_py:
	$(CC) --proto_path=$(PROTO) $(LISTA_SALA) --python_out=$(PYTHON_OUT)
reserva_py:
	$(CC) --proto_path=$(PROTO) $(RESERVA) --python_out=$(PYTHON_OUT)
lista_reserva_py:
	$(CC) --proto_path=$(PROTO) $(LISTA_RESERVA) --python_out=$(PYTHON_OUT)
usuario_py:
	$(CC) --proto_path=$(PROTO) $(AUTH_USUARIO) --python_out=$(PYTHON_OUT)
cadastro_usuario_py:
	$(CC) --proto_path=$(PROTO) $(CADASTRO_USUARIO) --python_out=$(PYTHON_OUT)
identificacao_py:
	$(CC) --proto_path=$(PROTO) $(IDENTIFICACAO) --python_out=$(PYTHON_OUT)
message_response_py:
	$(CC) --proto_path=$(PROTO) $(MESSAGE_RESPONSE) --python_out=$(PYTHON_OUT)

clean:
	rm -R ./server/model
	rm -R ./client/src/sd/ufc/reserva/model
	mkdir ./server/model