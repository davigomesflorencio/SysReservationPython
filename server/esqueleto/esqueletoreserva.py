from services.ServiceReserva import ServiceReserva
from model.Identificacao_pb2 import Identificacao
from model.Reserva_pb2 import Reserva
from model.MessageResponse_pb2 import MessageResponse
from google.protobuf.internal import encoder
from google.protobuf.internal import decoder

class EsqueletoReserva:

    def __init__(self):
        pass

    """

        METODOS

    """

    def listar_reservas(self,args):
        ident = self.desempacotaIdentificacao(args)
        lista = ServiceReserva().ListarReservas(ident.id)
        return self.empacota(lista)
    
    def listar_pedidos_reservas(self,args):
        ident = self.desempacotaIdentificacao(args)
        lista = ServiceReserva().ListarPedidoReservas(ident.id)
        return self.empacota(lista)

    def adicionar_pedido_reserva(self,args):
        reserva = self.desempacotaReserva(args)
        msgcallback = MessageResponse()
        if(ServiceReserva().AdicionarPedidoReserva(reserva)):
            msgcallback.mensagem = "Pedido adicionado"
        else:
            msgcallback.mensagem = "Pedido não adicionado"
        return self.empacota(msgcallback)
    
    def ver_pedido_reserva(self,args):
        reserva = self.desempacotaReserva(args)
        req = ServiceReserva().VerPedidoReserva(reserva)
        msgcallback = MessageResponse()
        if(req==None):
            msgcallback.mensagem = "Reserva não encontrada"
        msgcallback.mensagem = "Reserva: id "+str(req.id)+", id da sala "+str(req.id_sala)+", data "+req.data+", horario "+horario
        return self.empacota(msgcallback)
    
    def cancelar_pedido_reserva(self,args):
        reserva = self.desempacotaReserva(args)
        req = ServiceReserva().CancelarPedidoReserva(reserva)
        msgcallback = MessageResponse()
        if(req==True):
            msgcallback.mensagem = "Pedido de reserva cancelado: id "+str(reserva.id)
        else:
            msgcallback.mensagem = "Desculpe não foi possivel cancelar a reserva: id "+str(reserva.id)
        return self.empacota(msgcallback)

    """

        SERIALIZAÇÂO E DESERIALIZAÇÃO DAS IDL'S

    """

    def empacota(self,msg):
        out = msg.SerializeToString()
        out = encoder._VarintBytes(len(out)) + out
        return out

    def desempacotaIdentificacao(self,args): 
        msg = Identificacao()
        (size, position) = decoder._DecodeVarint(args, 0)
        msg.ParseFromString(args[position:position+size])
        return msg

    def desempacotaReserva(self,args): 
        msg = Reserva()
        (size, position) = decoder._DecodeVarint(args, 0)
        msg.ParseFromString(args[position:position+size])
        return msg
