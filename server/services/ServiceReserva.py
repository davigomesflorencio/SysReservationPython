from model.ListaReserva_pb2 import ListaReserva
from model.Reserva_pb2 import Reserva
from util.api import Api

class ServiceReserva:
    def __init__(self):
        pass

    def ListarReservas(self,id_usuario):
        reservas = ListaReserva()
        for x in Api().selectAllReservas(id_usuario):
            (ident, id_sala, id_usuario, data, horario) = x
            r =reservas.reservas.add()
            r.id = ident
            r.id_sala = id_sala
            r.id_usuario = id_usuario
            r.data = data
            r.horario = horario
        return reservas
    
    def ListarPedidoReservas(self,id_usuario):
        reservas = ListaReserva()
        for x in Api().selectAllPedidoReserva(id_usuario):
            (ident, id_sala, id_usuario, data, horario) = x
            r =reservas.reservas.add()
            r.id = ident
            r.id_sala = id_sala
            r.id_usuario = id_usuario
            r.data = data
            r.horario = horario
        return reservas
    
    def AdicionarPedidoReserva(self,reserva):
        id_sala = reserva.id_sala
        id_usuario = reserva.id_usuario
        data = reserva.data
        horario = reserva.horario
        return Api().insertPedidoReserva(id_sala,id_usuario,data,horario)
    
    def VerPedidoReserva(self,reserva):
        return Api().selectOnePedidoReserva(reserva.id)
    
    def CancelarPedidoReserva(self,reserva):
        print(reserva.id)
        return Api().cancelarPedidoReserva(reserva.id,reserva.id_usuario)