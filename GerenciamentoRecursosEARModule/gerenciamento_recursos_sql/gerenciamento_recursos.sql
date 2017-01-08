CREATE SCHEMA `gerenciador_recursos` ;

use gerenciador_recursos;

describe usuario;

select * from usuario;

describe perfil;

select * from perfil;

INSERT INTO gerenciador_recursos.perfil  SET NOME_PERFIL ='Administrador', ID_PERFIL=1;

INSERT INTO gerenciador.perfil  SET NOME_PERFIL ='Gerente', ID_PERFIL=3;

INSERT INTO gerenciador.perfil  SET NOME_PERFIL ='Professor', ID_PERFIL=2;

INSERT INTO gerenciador.perfil  SET NOME_PERFIL ='Assistente', ID_PERFIL=4;

INSERT INTO gerenciador_recursos.usuario  SET EMAIL ='pablo@uff', NOME='Pablo Curty', PASSWORD='admin'
, USERNAME='pfcfp', ID_PERFIL= (select ID_PERFIL from perfil where ID_PERFIL = 1), ID_USUARIO = 1, MATRICULA=1;