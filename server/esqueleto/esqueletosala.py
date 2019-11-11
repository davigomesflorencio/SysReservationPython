from services.ServiceSala import ServiceSala

class EsqueletoSala:
    def __init__(self):
        pass

    def listar_salas(self):
        return ServiceSala().ListarSalas().SerializeToString()
       
