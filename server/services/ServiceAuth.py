from util.api import Api

class ServiceAuth:
    def __init__(self):
        pass
    """

        USUARIO

    """    
    def Auth(self,nome ,senha):
        return Api().existsUsuario(nome,senha)
    
    def CreateUser(self,nome,usuario,senha,cpf,matricula,curso):
        return Api().insertUsuario(nome,usuario,senha,cpf,matricula,curso)
    
    """

        USUARIO ADMIN

    """
    def CreateAdmin(self,usuario,senha):
        return Api().insertAdmin(usuario,senha)

    def AuthAdmin(self,usuario,senha):
        return Api().existsAdmin(usuario,senha)
