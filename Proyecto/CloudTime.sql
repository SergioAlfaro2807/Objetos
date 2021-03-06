Use master
go
Create database CloudTime
go
USE [CloudTime]
GO
/****** Object:  Table [dbo].[Actividad]    Script Date: 16/12/2018 08:20:24 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Actividad](
	[codigo] [varchar](50) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[fecha_inicio] [date] NULL,
	[hora_inicio] [time](1) NULL,
	[fecha_fin] [date] NULL,
	[hora_fin] [time](1) NULL,
	[bitacora] [varchar](100) NULL,
	[descripcion] [nchar](200) NULL,
 CONSTRAINT [PK_Actividad] PRIMARY KEY CLUSTERED 
(
	[codigo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Bitacora]    Script Date: 16/12/2018 08:20:25 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Bitacora](
	[codigo] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Bitacora] PRIMARY KEY CLUSTERED 
(
	[codigo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ClienteFisico]    Script Date: 16/12/2018 08:20:25 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ClienteFisico](
	[primer_nombre] [varchar](30) NULL,
	[primer_apellido] [varchar](30) NULL,
	[segundo_apellido] [varchar](30) NULL,
	[correo] [varchar](200) NOT NULL,
	[telefono] [varchar](50) NULL,
	[provincia] [varchar](50) NULL,
	[canton] [varchar](50) NULL,
	[distrito] [varchar](50) NULL,
	[direccion_exacta] [varchar](300) NULL,
 CONSTRAINT [PK_Correo] PRIMARY KEY CLUSTERED 
(
	[correo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ClienteJuridico]    Script Date: 16/12/2018 08:20:25 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ClienteJuridico](
	[nombre] [varchar](30) NOT NULL,
	[identificacion] [varchar](9) NOT NULL,
	[telefono] [varchar](20) NOT NULL,
	[provincia] [varchar](50) NOT NULL,
	[canton] [varchar](50) NOT NULL,
	[distrito] [varchar](50) NOT NULL,
	[direccion_exacta] [varchar](200) NOT NULL,
	[contacto] [varchar](30) NOT NULL,
 CONSTRAINT [PK_identificacionJuridico] PRIMARY KEY CLUSTERED 
(
	[identificacion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Contacto]    Script Date: 16/12/2018 08:20:25 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Contacto](
	[primer_nombre] [varchar](30) NOT NULL,
	[primer_apellido] [varchar](30) NOT NULL,
	[segundo_apellido] [varchar](30) NOT NULL,
	[identificacion] [varchar](9) NOT NULL,
	[telefono] [varchar](20) NOT NULL,
	[correo] [varchar](200) NOT NULL,
 CONSTRAINT [PK_IdentificacionContacto] PRIMARY KEY CLUSTERED 
(
	[identificacion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Proyecto]    Script Date: 16/12/2018 08:20:25 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Proyecto](
	[codigo] [varchar](50) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[bitacora] [varchar](50) NOT NULL,
	[descripcion] [varchar](200) NOT NULL,
	[tipo] [varchar](10) NULL,
	[asociado] [varchar](50) NULL,
	[fechaInicio] [date] NULL,
	[fechaFin] [date] NULL,
 CONSTRAINT [PK_Proyecto] PRIMARY KEY CLUSTERED 
(
	[codigo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ProyectoxTecnologia]    Script Date: 16/12/2018 08:20:25 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ProyectoxTecnologia](
	[codigo] [int] IDENTITY(1,1) NOT NULL,
	[codigoProyecto] [varchar](50) NOT NULL,
	[codigoTecnologia] [varchar](20) NOT NULL,
 CONSTRAINT [PK_ProyectoxTecnologia] PRIMARY KEY CLUSTERED 
(
	[codigo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Tecnologia]    Script Date: 16/12/2018 08:20:25 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tecnologia](
	[codigo] [varchar](20) NOT NULL,
	[nombre] [varchar](50) NULL,
 CONSTRAINT [PK_tecnologia] PRIMARY KEY CLUSTERED 
(
	[codigo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Usuario]    Script Date: 16/12/2018 08:20:25 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Usuario](
	[identificacion] [varchar](30) NOT NULL,
	[primer_nombre] [varchar](30) NOT NULL,
	[primer_apellido] [varchar](30) NOT NULL,
	[segundo_apellido] [varchar](30) NULL,
	[correo] [varchar](200) NOT NULL,
	[genero] [varchar](10) NULL,
	[avatar] [varchar](50) NOT NULL,
	[contrasenna] [varchar](100) NOT NULL,
 CONSTRAINT [PK_identficacionUsuario] PRIMARY KEY CLUSTERED 
(
	[identificacion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Actividad] ADD  CONSTRAINT [DF__Actividad__fecha__08B54D69]  DEFAULT (NULL) FOR [fecha_inicio]
GO
ALTER TABLE [dbo].[Actividad] ADD  CONSTRAINT [DF__Actividad__hora___09A971A2]  DEFAULT ('') FOR [hora_inicio]
GO
ALTER TABLE [dbo].[Actividad] ADD  CONSTRAINT [DF__Actividad__fecha__0A9D95DB]  DEFAULT (NULL) FOR [fecha_fin]
GO
ALTER TABLE [dbo].[Actividad] ADD  CONSTRAINT [DF__Actividad__hora___0B91BA14]  DEFAULT ('') FOR [hora_fin]
GO
ALTER TABLE [dbo].[ProyectoxTecnologia]  WITH CHECK ADD  CONSTRAINT [FK__Proyectox__codig__114A936A] FOREIGN KEY([codigoProyecto])
REFERENCES [dbo].[Proyecto] ([codigo])
GO
ALTER TABLE [dbo].[ProyectoxTecnologia] CHECK CONSTRAINT [FK__Proyectox__codig__114A936A]
GO
ALTER TABLE [dbo].[ProyectoxTecnologia]  WITH CHECK ADD FOREIGN KEY([codigoTecnologia])
REFERENCES [dbo].[Tecnologia] ([codigo])
GO
/****** Object:  StoredProcedure [dbo].[registrar_actividad_sinFecha]    Script Date: 16/12/2018 08:20:25 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create procedure [dbo].[registrar_actividad_sinFecha]
@codigoActividad varchar(50),
@nombreActividad varchar(50),
@bitacora varchar(100),
@descripcion varchar(200)
as
Insert into Actividad (codigo, nombre, bitacora, descripcion)
Values(@codigoActividad, @nombreActividad, @bitacora,@descripcion)
GO
/****** Object:  StoredProcedure [dbo].[sp_eliminar_cliente_fisico]    Script Date: 16/12/2018 08:20:25 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

Create Procedure [dbo].[sp_eliminar_cliente_fisico]

@correo varchar(200)
AS
Delete from ClienteFisico
Where correo = @correo
GO
/****** Object:  StoredProcedure [dbo].[sp_eliminar_cliente_juridico]    Script Date: 16/12/2018 08:20:25 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create procedure [dbo].[sp_eliminar_cliente_juridico]
@identificacion varchar(9)
as
Delete from ClienteJuridico
Where identificacion = @identificacion

GO
/****** Object:  StoredProcedure [dbo].[sp_eliminar_contacto]    Script Date: 16/12/2018 08:20:25 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create procedure [dbo].[sp_eliminar_contacto]
@identificacion varchar(9)
as
Delete from Contacto
Where identificacion = @identificacion
GO
/****** Object:  StoredProcedure [dbo].[sp_eliminar_proyecto]    Script Date: 16/12/2018 08:20:25 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create procedure [dbo].[sp_eliminar_proyecto]
@codigoProyecto varchar(50)
as
Delete from Proyecto
Where codigo = @codigoProyecto
GO
/****** Object:  StoredProcedure [dbo].[sp_eliminar_ProyectoxTecnologia]    Script Date: 16/12/2018 08:20:25 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create procedure [dbo].[sp_eliminar_ProyectoxTecnologia]
@codigoProyecto varchar(50),
@codigoTecnologia varchar(20)
as
Delete from ProyectoxTecnologia
Where codigoProyecto = @codigoProyecto and codigoTecnologia = @codigoTecnologia
GO
/****** Object:  StoredProcedure [dbo].[sp_eliminar_tecnologia]    Script Date: 16/12/2018 08:20:25 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create procedure [dbo].[sp_eliminar_tecnologia]
@nombre varchar(50),
@codigo varchar(20)
as
Delete Tecnologia
Where codigo = @codigo
GO
/****** Object:  StoredProcedure [dbo].[sp_iniciar_actividad]    Script Date: 16/12/2018 08:20:25 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[sp_iniciar_actividad]
@codigoActividad varchar(50),
@fechaInicio date,
@horaInicio time(5)
as
Update Actividad set fecha_inicio = @fechaInicio, hora_inicio = @horaInicio where codigo = @codigoActividad
GO
/****** Object:  StoredProcedure [dbo].[sp_modificar_cliente_fisico]    Script Date: 16/12/2018 08:20:25 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

Create Procedure [dbo].[sp_modificar_cliente_fisico]
@primer_nombre varchar(30),
 @primer_apellido varchar(30),
  @segundo_apellido varchar(30),
  @correo varchar(200),
  @telefono varchar(50),
  @provincia varchar(50),
  @canton varchar(50),
  @distrito varchar (50),
  @direccion_exacta varchar(300),
@correobuscar varchar (200)
  As
  Update ClienteFisico
  set [primer_nombre] = @primer_nombre, [primer_apellido] = @primer_apellido, [segundo_apellido] = @segundo_apellido,
   [correo] = @correo, [telefono] = @telefono, [provincia] = @provincia, [canton] = @canton, [distrito] = @distrito, [direccion_exacta] = @direccion_exacta
  Where [correo] = @correobuscar
  
GO
/****** Object:  StoredProcedure [dbo].[sp_modificar_cliente_juridico]    Script Date: 16/12/2018 08:20:25 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
  Create Procedure [dbo].[sp_modificar_cliente_juridico]
@cedula varchar(9),
 @contacto varchar(30),
 @primer_nombre varchar(30),
  @provincia varchar(50),
  @canton varchar(50),
  @distrito varchar(50),
  @direccionExacta varchar(200),
  @telefono varchar(20),
  @cedulaBuscar varchar(9)

AS
Update ClienteJuridico
set nombre = @primer_nombre, identificacion = @cedula, telefono = @telefono, provincia = @provincia, canton = @canton, distrito = @distrito, direccion_exacta = @direccionExacta, contacto = @contacto
Where identificacion = @cedulaBuscar
GO
/****** Object:  StoredProcedure [dbo].[sp_modificar_contacto]    Script Date: 16/12/2018 08:20:25 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

  Create Procedure [dbo].[sp_modificar_contacto]
@primer_nombre varchar(30),
@primer_apellido varchar(30),
 @segundo_apellido varchar(30),
  @identificacion varchar(9),
  @telefono varchar(20),
  @correo varchar(200),
  @identificacionBuscar varchar(9)
AS
Update Contacto
Set primer_nombre = @primer_nombre, primer_apellido = @primer_apellido, segundo_apellido = @segundo_apellido, identificacion = @identificacion, telefono = @telefono, correo = @correo 
Where identificacion = @identificacionBuscar
GO
/****** Object:  StoredProcedure [dbo].[sp_modificar_contrasenna]    Script Date: 16/12/2018 08:20:25 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create procedure [dbo].[sp_modificar_contrasenna]
@contrasennaVieja varchar(100),
@contrasennaNueva varchar(100)
as
Update Usuario set contrasenna = @contrasennaNueva where contrasenna = @contrasennaVieja
GO
/****** Object:  StoredProcedure [dbo].[sp_modificar_contrasenna_correo]    Script Date: 16/12/2018 08:20:25 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create procedure [dbo].[sp_modificar_contrasenna_correo]
@contrasennaNueva varchar(100),
@correo varchar(200)
as
Update Usuario set contrasenna = @contrasennaNueva where correo = @correo
GO
/****** Object:  StoredProcedure [dbo].[sp_modificar_proyecto]    Script Date: 16/12/2018 08:20:25 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create procedure [dbo].[sp_modificar_proyecto]
@descripcion varchar(200),
@nombre varchar(50),
@codigo varchar(50),
@codigoModificar varchar(50)
as
Update Proyecto
Set codigo = @codigo, descripcion = @descripcion, nombre = @nombre where codigo = @codigoModificar
GO
/****** Object:  StoredProcedure [dbo].[sp_modificar_tecnologia]    Script Date: 16/12/2018 08:20:25 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create procedure [dbo].[sp_modificar_tecnologia]
@nombre varchar(50),
@codigo varchar(20),
@codigoModificar varchar(20)
as
Update Tecnologia
set nombre = @nombre, codigo = @codigo
Where codigo = @codigoModificar
GO
/****** Object:  StoredProcedure [dbo].[sp_registrar_actividad_manual]    Script Date: 16/12/2018 08:20:25 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create procedure [dbo].[sp_registrar_actividad_manual]
@codigoActividad varchar(50),
@nombreActividad varchar(50),
@bitacora varchar(100),
@descripcion varchar(200),
@fechainicio date,
@horainicio time(5),
@fechafin date,
@horafin time(5)
as
Insert into Actividad (codigo, nombre, fecha_inicio, hora_inicio, fecha_fin, hora_fin, bitacora, descripcion)
Values(@codigoActividad, @nombreActividad, @fechainicio, @horainicio, @fechafin, @horafin, @bitacora,@descripcion)
GO
/****** Object:  StoredProcedure [dbo].[sp_registrar_bitacora]    Script Date: 16/12/2018 08:20:25 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create procedure [dbo].[sp_registrar_bitacora]
@nombre varchar(50)
as
Insert into Bitacora
Values(@nombre)
GO
/****** Object:  StoredProcedure [dbo].[sp_registrar_cliente_fisico]    Script Date: 16/12/2018 08:20:25 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

Create Procedure [dbo].[sp_registrar_cliente_fisico]
@primer_nombre varchar(30),
@primer_apellido varchar(30),
@segundo_apellido varchar(30),
@correo varchar(200),
@telefono varchar(50),
@provincia varchar(50),
@canton varchar(50),
@distrito varchar(50),
@direccion_exacta varchar(300)

AS
Insert into ClienteFisico
Values (@primer_nombre, @primer_apellido, @segundo_apellido, @correo, @telefono, @provincia, @canton, @distrito, @direccion_exacta)
GO
/****** Object:  StoredProcedure [dbo].[sp_registrar_cliente_juridico]    Script Date: 16/12/2018 08:20:25 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
  Create Procedure [dbo].[sp_registrar_cliente_juridico]
@cedula varchar(9),
 @contacto varchar(30),
 @primer_nombre varchar(30),
  @provincia varchar(50),
  @canton varchar(50),
  @distrito varchar(50),
  @direccionExacta varchar(200),
  @telefono varchar(20)

AS
Insert into ClienteJuridico
Values (@primer_nombre, @cedula, @telefono, @provincia, @canton, @distrito, @direccionExacta,@contacto)
GO
/****** Object:  StoredProcedure [dbo].[sp_registrar_contacto]    Script Date: 16/12/2018 08:20:25 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
  Create Procedure [dbo].[sp_registrar_contacto]
@primer_nombre varchar(30),
@primer_apellido varchar(30),
 @segundo_apellido varchar(30),
  @identificacion varchar(9),
  @telefono varchar(20),
  @correo varchar(200)
AS
Insert into Contacto
Values (@primer_nombre, @primer_apellido, @segundo_apellido, @identificacion, @telefono, @correo)
GO
/****** Object:  StoredProcedure [dbo].[sp_registrar_proyecto]    Script Date: 16/12/2018 08:20:25 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[sp_registrar_proyecto]
@codigo varchar(50),
@nombre varchar(50),
@bitacora varchar(50),
@descripcion varchar(200),
@tipo varchar(10),
@asociado varchar(50),
@fechaInicio date,
@fechaFin date
as
Insert into Proyecto
Values(@codigo, @nombre, @bitacora, @descripcion, @tipo, @asociado, @fechaInicio, @fechaFin)
GO
/****** Object:  StoredProcedure [dbo].[sp_registrar_ProyectoxTecnologia]    Script Date: 16/12/2018 08:20:25 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create procedure [dbo].[sp_registrar_ProyectoxTecnologia]
@idProyecto varchar(50),
@idTecnologia varchar(20)
as
Insert into ProyectoxTecnologia
Values(@idProyecto, @idTecnologia)
GO
/****** Object:  StoredProcedure [dbo].[sp_registrar_tecnologia]    Script Date: 16/12/2018 08:20:25 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create procedure [dbo].[sp_registrar_tecnologia]
@codigo varchar(20),
@nombre varchar(50)
as
Insert into Tecnologia Values(@codigo, @nombre)
GO
/****** Object:  StoredProcedure [dbo].[sp_registrar_usuario]    Script Date: 16/12/2018 08:20:25 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Procedure [dbo].[sp_registrar_usuario] 
@identificacion varchar(30),
 @primer_nombre varchar(30),
  @primer_apellido varchar(30),
  @segundo_apellido varchar(30),
  @correo varchar(200),
  @genero char(1),
  @avatar varchar(50),
  @contrasenna varchar(100)

AS
Insert into Usuario
Values (@identificacion, @primer_nombre, @primer_apellido, @segundo_apellido, @correo, @genero, @avatar, @contrasenna)
GO
/****** Object:  StoredProcedure [dbo].[sp_terminar_actividad]    Script Date: 16/12/2018 08:20:25 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create procedure [dbo].[sp_terminar_actividad]
@codigoActividad varchar(50),
@fechaInicio date,
@horaInicio time(5)
as
Update Actividad set fecha_fin = @fechaInicio, hora_fin = @horaInicio where codigo = @codigoActividad
GO
