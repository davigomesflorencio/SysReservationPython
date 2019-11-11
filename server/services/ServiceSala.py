from model.ListaSala_pb2 import ListaSala
from util.api import Api

class ServiceSala:
    def __init__(self):
        pass

    def ListarSalas(self):
        salas = ListaSala()
        for x in Api().selectAllSalas():
            (ident,nome,bloco)=x 
            sala = salas.list.add()
            sala.id_sala = ident
            sala.nome = nome
            sala.bloco = bloco
        return salas
