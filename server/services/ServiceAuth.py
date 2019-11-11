from util.api import Api

class ServiceAuth:
    def __init__(self):
        pass

    def Auth(self,nome ,senha):
        return Api().existsUsuario(nome,senha)
    
    def CreateUser(self,nome,usuario,senha,cpf,matricula,curso):
        return Api().insertUsuario(nome,usuario,senha,cpf,matricula,curso)
