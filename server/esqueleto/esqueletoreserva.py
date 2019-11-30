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
        msgresponse = MessageResponse()
        req=ServiceReserva().AdicionarPedidoReserva(reserva)
        if(req==1):
             msgresponse.mensagem = "ID da sala não existe"
        elif (req==2):
            msgresponse.mensagem = "Pedido de reserva adicionado"
        else:
            msgresponse.mensagem = "Pedido de reserva não adicionado, já existe uma reserva com essas informações"
        return self.empacota(msgresponse)
    
    def ver_pedido_reserva(self,args):
        reserva = self.desempacotaReserva(args)
        req = ServiceReserva().VerPedidoReserva(reserva)
        msgresponse = MessageResponse()
        if(req==None):
            msgresponse.mensagem = "Reserva não encontrada: ID da reserva "+str(reserva.id)
        else:
            (ident,ident_usuario, id_sala,data,horario)=req
            msgresponse.mensagem = "Reserva encontrada : ID da reserva : "+str(ident)+", ID da sala : "+str(id_sala)+" ,Data : "+data+" , Horario : "+horario
        return self.empacota(msgresponse)
    
    def cancelar_reserva(self,args):
        reserva = self.desempacotaReserva(args)
        req = ServiceReserva().CancelarReservaUser(reserva)
        msgresponse = MessageResponse()
        if(req==True):
            msgresponse.mensagem = "Reserva cancelada: ID solicitado "+str(reserva.id)
        else:
            msgresponse.mensagem = "Desculpe não foi possivel cancelar a reserva com a identificação solicitado : ID da reserva "+str(reserva.id)
        return self.empacota(msgresponse)

    def listar_historico(self,args):
        ident = self.desempacotaIdentificacao(args)
        lista = ServiceReserva().ListarHistorico(ident.id)
        return self.empacota(lista)

    """

        ADMIN

    """

    def listar_pedidos_reservas_admin(self):
        lista = ServiceReserva().ListarPedidoReservasAdmin()
        return self.empacota(lista)
        
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
