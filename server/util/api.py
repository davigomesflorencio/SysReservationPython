import mysql.connector
from mysql.connector import Error
from datetime import datetime as dt


class Api:
	def __init__(self):
		pass
	"""

		CONFIG

	"""
	def dbconfig(self):
		conn = mysql.connector.connect(
				host="localhost",
				user="root",
				password="root",
				database="reserva"
		)
		return conn

	"""

		CREATE TABLES

	"""
	def createTables(self):
		conn = self.dbconfig()
		cursor = conn.cursor()

		try:
			cursor.execute(
					"CREATE TABLE usuario"
					+"(id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT"
					+",nome VARCHAR(255) NOT NULL"
					+",usuario VARCHAR(255) NOT NULL"
					+",senha VARCHAR(255) NOT NULL"
					+",cpf VARCHAR(255) NOT NULL"
					+",matricula VARCHAR(6) NOT NULL"
					+",curso VARCHAR(255) NOT NULL)")
			
			cursor.execute(
					"CREATE TABLE salas"
					+"(id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT"
					+",nome VARCHAR(255) NOT NULL"
					+",bloco VARCHAR(255) NOT NULL)")

			cursor.execute("CREATE TABLE pedidos_reservas"
					+"(id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT"
					+",id_usuario INT(11) NOT NULL"
					+",id_sala INT(11) NOT NULL"
					+",data VARCHAR(255) NOT NULL"
					+",horario VARCHAR(255) NOT NULL)")
			
			cursor.execute("CREATE TABLE reservas"
					+"(id INT(11) NOT NULL PRIMARY KEY"
					+",id_usuario INT(11) NOT NULL"
					+",id_sala INT(11) NOT NULL"
					+",data VARCHAR(255) NOT NULL"
					+",horario VARCHAR(255) NOT NULL)")

			cursor.execute(
					"ALTER TABLE pedidos_reservas ADD CONSTRAINT fk_id_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id)")
			cursor.execute(
					"ALTER TABLE pedidos_reservas ADD CONSTRAINT fk_id_sala FOREIGN KEY (id_sala) REFERENCES salas(id)")

			cursor.execute(
					"ALTER TABLE reservas ADD CONSTRAINT fk_id_usuario_reserva FOREIGN KEY (id_usuario) REFERENCES usuario(id)")
			cursor.execute(
					"ALTER TABLE reservas ADD CONSTRAINT fk_id_sala_reserva FOREIGN KEY (id_sala) REFERENCES salas(id)")

		except Error as error:
			print(error)

		finally:
			cursor.close()
			conn.close()


	"""

		USUARIO

	"""

	def insertUsuario(self,nome,usuario,senha,cpf,matricula,curso):
		if(self.existsMatriculaUsuario(usuario)==None):
			query = "INSERT INTO usuario(nome,usuario,senha,cpf,matricula,curso) VALUES (%s,%s,md5(%s),%s,%s,%s)"
			args = (nome,usuario,senha,cpf,matricula,curso)
			conn = self.dbconfig()
			cursor = conn.cursor()
			try:
				cursor.execute(query, args)

				r = False
				if cursor.lastrowid:
					r = True
				else:
					r = False

				conn.commit()
				return r
			except Error as error:
				print(error)
				return False

			finally:
				cursor.close()
				conn.close()
		else:
			return False

	def existsMatriculaUsuario(self,usuario):
		query = "select * from usuario where matricula=%s"
		conn = self.dbconfig()
		cursor = conn.cursor()
		try:
			cursor.execute(query,(usuario,))
			usuario = cursor.fetchone()
			r=None
			if(cursor.rowcount>0):
				r=usuario

			return r
		except Error as error:
			print(error)
			return None

		finally:
			conn.close()

	def existsUsuario(self,usuario,senha):
		query = "select * from usuario where matricula=%s and senha=md5(%s)"
		conn = self.dbconfig()
		cursor = conn.cursor()
		try:
			cursor.execute(query,(usuario,senha))
			usuario = cursor.fetchone()
			r=None
			if(cursor.rowcount>0):
				r=usuario

			return r
		except Error as error:
			print(error)
			return None

		finally:
			conn.close()

	"""

		SALAS

	"""
	def insertSalas(self,salas):
		query = "INSERT INTO salas(nome,bloco) VALUES(%s,%s)"
		conn = self.dbconfig()
		cursor = conn.cursor()
		try:
			cursor.executemany(query, salas)
			r = False
			if cursor.lastrowid:
				r = True
			conn.commit()
			return r
		except Error as error:
			print(error)
			return False

		finally:
			cursor.close()
			conn.close()

	def selectAllSalas(self):
		query = "select * from salas"
		conn = self.dbconfig()
		cursor = conn.cursor()
		try:
			cursor.execute(query)
			salas = cursor.fetchall()
			conn.commit()
			return salas
		except Error as error:
			print(error)
			return []
		finally:
			cursor.close()
			conn.close()

	def selectOneSala(self,id_sala):
		query = "select * from salas where id=%s"
		conn = self.dbconfig()
		cursor = conn.cursor()
		try:	
			cursor.execute(query,(id_sala,))
			sala = cursor.fetchone()
			conn.commit()

			return sala
		except Error as error:
			print(error)
			return None

		finally:
			cursor.close()
			conn.close()

	def deleteSala(self,id):
		query = "delete from salas where id=%s"
		try:
			conn = self.dbconfig()
			cursor = conn.cursor()
			cursor = conn.cursor()
			cursor.execute(query, (id,))

			conn.commit()
			return True
		except Error as error:
			print(error)
			return False

		finally:
			cursor.close()
			conn.close()

	"""

		PEDIDOS RESERVAS


	"""
	def insertPedidoReserva(self,id_sala, id_usuario, data, horario):
		if(self.existsReserva(id_sala,data,horario)==None):
			if(dt.strptime(data,"%d/%m/%Y")>=dt.today()):
				query = "INSERT INTO pedidos_reservas(id_usuario,id_sala,data,horario) VALUES (%s,%s,%s,%s)"
				args = (id_usuario, id_sala, data, horario)
			
				conn = self.dbconfig()
				cursor = conn.cursor()
				try:
					cursor.execute(query, args)

					r = False
					if cursor.lastrowid:
						r = True
					conn.commit()
					return r
				except Error as error:
					print(error)
					return False
			
				finally:
					cursor.close()
					conn.close()
			else:
				return False
		else:
			return False

	def selectOnePedidoReserva(self,id_reserva):
		query = "select * from pedidos_reservas where id=%s"
		args = (id_reserva,)
		conn = self.dbconfig()
		cursor = conn.cursor()
		try:
			cursor.execute(query, args)
			reserva = cursor.fetchone()
			conn.commit()
			return reserva
		except Error as error:
			print(error)
			return ()

		finally:
			cursor.close()
			conn.close()

	def cancelarPedidoReserva(self,id_pedido_reserva,id_usuario):
		res = self.selectOnePedidoReserva(id_pedido_reserva)

		if(res != None):
			print(res)
			ident, id_usuario, id_sala, data, horario = res
			if(dt.strptime(data, "%d/%m/%Y") >= dt.today()):
				query = "DELETE FROM pedidos_reservas WHERE id = %s and id_usuario= %s"
				conn = self.dbconfig()
				cursor = conn.cursor()
				try:
					cursor.execute(query, (ident,id_usuario))
					conn.commit()
					return True
				except Error as error:
					print(error)
					return False

				finally:
					cursor.close()
					conn.close()
			else:
				print("asklaskla")
				return False
		else:
			return False

	def selectAllPedidoReserva(self,id_usuario):
		query = "select * from pedidos_reservas where id_usuario=%s"
		try:
			conn = self.dbconfig()
			cursor = conn.cursor()
			cursor.execute(query,(id_usuario,))
			reservas = cursor.fetchall()
			conn.commit()

			return reservas
		except Error as error:
			print(error)
			return []

		finally:
			cursor.close()
			conn.close()
	
	def existsReserva(self,id_sala,data,horario):
		query = "select * from reservas where id_sala=%s and data=%s and horario=%s"
		args = (id_sala,data,horario)
		conn = self.dbconfig()
		cursor = conn.cursor()
		try:
			cursor.execute(query, args)
			reserva = cursor.fetchone()
			conn.commit()
			return reserva
		except Error as error:
			print(error)
			return ()
		finally:
			cursor.close()
			conn.close()

	"""

		RESERVAS

	"""
	def selectOneReserva(self,id_reserva):
		query = "select * from reservas where id=%s"
		args = (id_reserva,)
		try:
			conn = self.dbconfig()
			cursor = conn.cursor()
			cursor.execute(query, args)
			reserva = cursor.fetchone()
			conn.commit()

			return reserva
		except Error as error:
			print(error)
			return ()

		finally:
			cursor.close()
			conn.close()
			
	def cancelarReserva(self,id_reserva):
		reserva = selectOneReserva(id_reserva)

		if(reserva != ()):
			(ident,id_usuario ,id_sala, data, horario) = reserva
			if(dt.strptime(data, "%d/%m/%Y") >= dt.today().strftime("%d/%m/%Y")):
				query = "DELETE FROM reservas WHERE id = %s"
				try:
					conn = self.dbconfig()
					cursor = conn.cursor()
					cursor.execute(query, (id_reserva,))
					conn.commit()
					return True
				except Error as error:
					print(error)
					return False

				finally:
					cursor.close()
					conn.close()
			else:
				return False
		else:
			return False

	def selectAllReservas(self,id_usuario):
		query = "select reservas.id,reservas.data, reservas.horario,salas.* from reservas INNER JOIN salas where reservas.id_usuario=%s and reservas.id_sala=salas.id"
		conn = self.dbconfig()
		cursor = conn.cursor()
		try:
			cursor.execute(query,(id_usuario,))
			reservas = cursor.fetchall()
			conn.commit()

			return reservas
		except Error as error:
			print(error)
			return []

		finally:
			cursor.close()
			conn.close()


"""

	METODO PRINCIPAL

"""
def main():
	# Api().createTables()

	# if(Api().insertUsuario("Davi Gomes","davi","123","074.165.083-55","397328","CC")):
	# 	print("inseriu usuario")
	# if(Api().insertUsuario("Alan Gomes","alan","123456","074.165.088-55","397329","EC")):
	# 	print("inseriu usuario")

	# if(Api().existsUsuario("davi","123")):
	# 	print("exists ")

	# salas=[("Sala 1","Bloco 1"),("Sala 2","Bloco 1"),("Sala 3","Bloco 1"),("Sala 4","Bloco 1"),("Sala 5","Bloco 1")]
	# if(Api().insertSalas(salas)):
	# 	print("inseriu salas")

	# print(Api().selectOneSala(16))

	print(Api().selectAllSalas())

	


if __name__ == '__main__':
		main()
