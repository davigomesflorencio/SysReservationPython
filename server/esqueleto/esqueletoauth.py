from services.ServiceAuth import ServiceAuth
from model.AuthUsuario_pb2 import AuthUsuario
from model.CadastroUsuario_pb2 import CadastroUsuario

from model.MessageCallback_pb2 import MessageCallback
from model.Identificacao_pb2 import Identificacao
from google.protobuf.internal import encoder
from google.protobuf.internal import decoder

class EsqueletoAuth:
    def __init__(self):
        pass

    """

        METODOS
        
    """

    def auth(self,args):
        auth_user = self.desempacotaAuthUsuario(args)
        res= ServiceAuth().Auth(auth_user.usuario,auth_user.senha)
        identificacao =Identificacao()
        if(res!=None):
            (ident,nome,usuario,senha,cpf,matricula,curso) =res
            identificacao.id = int(ident)
        else:
            identificacao.id = -1
        return self.empacota(identificacao)

    def cadastro_usuario(self,args):
        cad_user = self.desempacotaCadastroUsuario(args)
        res = ServiceAuth().CreateUser(cad_user.nome,cad_user.usuario,cad_user.senha,cad_user.cpf,cad_user.matricula,cad_user.curso)
        msgcallback = MessageCallback()
        if(res):
            msgcallback.mensagem = "Cadastro realizado com sucesso"
        else:
            msgcallback.mensagem = "Desculpe não foi possivel realizar o cadastro"
        return self.empacota(msgcallback)
    
    """

        SERIALIZAÇÂO E DESERIALIZAÇÃO DAS IDL'S

    """

    def empacota(self,msg):
        out = msg.SerializeToString()
        out = encoder._VarintBytes(len(out)) + out
        return out

    def desempacotaAuthUsuario(self,args): 
        msg = AuthUsuario()
        (size, position) = decoder._DecodeVarint(args, 0)
        msg.ParseFromString(args[position:position+size])
        return msg
    
    def desempacotaCadastroUsuario(self,args): 
        msg = CadastroUsuario()
        (size, position) = decoder._DecodeVarint(args, 0)
        msg.ParseFromString(args[position:position+size])
        return msg
    

