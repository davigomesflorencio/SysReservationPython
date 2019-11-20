import socket
import model.Mensagem_pb2
from google.protobuf.internal import encoder
from google.protobuf.internal import decoder
import time
from despachante import Despachante

localIP = '127.0.0.1'
localPort = 20001
bufferSize = 1024
lastMessageID = None
UDPServerSocket = socket.socket(family=socket.AF_INET, type=socket.SOCK_DGRAM)


def getRequest():
     aux, cliente = UDPServerSocket.recvfrom(bufferSize)
     req = desempacotaMensagem(aux)
     return req, cliente


def sendReply(msg, args, adress):
    msg.messageType = 1
    msg.arguments = args
    msg = empacotaMensagem(msg)
    UDPServerSocket.sendto(msg, adress)


def empacotaMensagem(msg):
    out = msg.SerializeToString()
    out = encoder._VarintBytes(len(out)) + out
    return out


def desempacotaMensagem(args):
    msg = model.Mensagem_pb2.Mensagem()
    (size, position) = decoder._DecodeVarint(args, 0)
    msg.ParseFromString(args[position:position+size])
    return msg


def imprimeInfoMensagem(msg):
    print("----------------------------------")
    print("Tipo", msg.messageType)
    print("request id", msg.request_id)
    print("object reference", msg.object_reference)
    print("Metodo", msg.method)
    print("----------------------------------")


def main():
    UDPServerSocket.bind((localIP, localPort))
    print("UDP server executando")
    cont = -1
    while(True):
        mensagem, cliente = getRequest()
        if(lastMessageID != mensagem.request_id):
            lastMessageID = mensagem.request_id
            #cont = cont + 1
            #if(cont<2):
            #    print(cont)
            #    continue
            imprimeInfoMensagem(mensagem)
            des = Despachante
            sendReply(mensagem, des.invoke(mensagem), cliente)
        else:
            print("Mensagem duplicada : ID -> ", lastMessageID)


if __name__ == '__main__':
    main()
