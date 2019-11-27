from esqueleto.esqueletosala import EsqueletoSala
from esqueleto.esqueletoreserva import EsqueletoReserva
from esqueleto.esqueletoauth import EsqueletoAuth


class Despachante:

    def invoke(Mensagem):
        if(Mensagem.object_reference=="ReferenceSala"):
            if(Mensagem.method=="Metodo_listar_salas"):
                return EsqueletoSala().listar_salas()
        
        if(Mensagem.object_reference=="ReferenceReserva"):
            if(Mensagem.method=="Metodo_adicionar_pedido_reserva"):
                return EsqueletoReserva().adicionar_pedido_reserva(Mensagem.arguments)
            if(Mensagem.method=="Metodo_listar_reservas"):
                return EsqueletoReserva().listar_reservas(Mensagem.arguments)
            if(Mensagem.method=="Metodo_listar_pedido_reservas"):
                return EsqueletoReserva().listar_pedidos_reservas(Mensagem.arguments)
            if(Mensagem.method=="Metodo_ver_pedido_reserva"):
                return EsqueletoReserva().ver_pedido_reserva(Mensagem.arguments)
            if(Mensagem.method=="Metodo_cancelar_reserva"):
                return EsqueletoReserva().cancelar_reserva(Mensagem.arguments)
            if(Mensagem.method=="Metodo_listar_historico"):
                return EsqueletoReserva().listar_historico(Mensagem.arguments)
        
        if(Mensagem.object_reference=="ReferenceAuth"):
            if(Mensagem.method=="Metodo_autenticar"):
                return EsqueletoAuth().auth(Mensagem.arguments)                
            if(Mensagem.method=="Metodo_cadastro_usuario"):                
                return EsqueletoAuth().cadastro_usuario(Mensagem.arguments)

        