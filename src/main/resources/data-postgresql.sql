-- Estado
INSERT INTO estado(id, uf, nome) VALUES (nextval('estado_id_seq'), 'AC', 'Acre');
INSERT INTO estado(id, uf, nome) VALUES (nextval('estado_id_seq'), 'AL', 'Alagoas');
INSERT INTO estado(id, uf, nome) VALUES (nextval('estado_id_seq'), 'AM', 'Manaus');
INSERT INTO estado(id, uf, nome) VALUES (nextval('estado_id_seq'), 'AP', 'Amapá');
INSERT INTO estado(id, uf, nome) VALUES (nextval('estado_id_seq'), 'BA', 'Bahia');
INSERT INTO estado(id, uf, nome) VALUES (nextval('estado_id_seq'), 'CE', 'Ceará');
INSERT INTO estado(id, uf, nome) VALUES (nextval('estado_id_seq'), 'DF', 'Distrito Federal');
INSERT INTO estado(id, uf, nome) VALUES (nextval('estado_id_seq'), 'ES', 'Espírito Santo');
INSERT INTO estado(id, uf, nome) VALUES (nextval('estado_id_seq'), 'GO', 'Goiais');
INSERT INTO estado(id, uf, nome) VALUES (nextval('estado_id_seq'), 'MA', 'Maranhão');
INSERT INTO estado(id, uf, nome) VALUES (nextval('estado_id_seq'), 'MG', 'Minas Gerais');
INSERT INTO estado(id, uf, nome) VALUES (nextval('estado_id_seq'), 'MS', 'Mato Grosso do Sul');
INSERT INTO estado(id, uf, nome) VALUES (nextval('estado_id_seq'), 'MT', 'Mato Grosso');
INSERT INTO estado(id, uf, nome) VALUES (nextval('estado_id_seq'), 'PA', 'Pará');
INSERT INTO estado(id, uf, nome) VALUES (nextval('estado_id_seq'), 'PB', 'Paraíba');
INSERT INTO estado(id, uf, nome) VALUES (nextval('estado_id_seq'), 'PE', 'Pernambuco');
INSERT INTO estado(id, uf, nome) VALUES (nextval('estado_id_seq'), 'PI', 'Piauí');
INSERT INTO estado(id, uf, nome) VALUES (nextval('estado_id_seq'), 'PR', 'Paraná');
INSERT INTO estado(id, uf, nome) VALUES (nextval('estado_id_seq'), 'RJ', 'Rio de Janeiro');
INSERT INTO estado(id, uf, nome) VALUES (nextval('estado_id_seq'), 'RN', 'Rio Grande do Norte');
INSERT INTO estado(id, uf, nome) VALUES (nextval('estado_id_seq'), 'RO', 'Rondônia');
INSERT INTO estado(id, uf, nome) VALUES (nextval('estado_id_seq'), 'RR', 'Roraima');
INSERT INTO estado(id, uf, nome) VALUES (nextval('estado_id_seq'), 'RS', 'Rio Grande do Sul');
INSERT INTO estado(id, uf, nome) VALUES (nextval('estado_id_seq'), 'SC', 'Santa Catarina');
INSERT INTO estado(id, uf, nome) VALUES (nextval('estado_id_seq'), 'SE', 'Sergipe');
INSERT INTO estado(id, uf, nome) VALUES (nextval('estado_id_seq'), 'SP', 'São Paulo');
INSERT INTO estado(id, uf, nome) VALUES (nextval('estado_id_seq'), 'TO', 'Tocantins');

-- Cidade
-- INSERT INTO cidade(id, codigo, nome, estado_id) VALUES (nextval('cidade_id_seq'), 8650, 'Rio do Sul', (SELECT id FROM estado WHERE uf = 'SC'));
-- INSERT INTO cidade(id, codigo, nome, estado_id) VALUES (nextval('cidade_id_seq'), 8727, 'Taió', (SELECT id FROM estado WHERE uf = 'SC'));
-- INSERT INTO cidade(id, codigo, nome, estado_id) VALUES (nextval('cidade_id_seq'), 8377, 'Blumenau', (SELECT id FROM estado WHERE uf = 'SC'));
-- 
-- INSERT INTO cidade(id, codigo, nome, estado_id) VALUES (nextval('cidade_id_seq'), 6015, 'Curitiba', (SELECT id FROM estado WHERE uf = 'PR'));
-- INSERT INTO cidade(id, codigo, nome, estado_id) VALUES (nextval('cidade_id_seq'), 6471, 'Ponta Grossa', (SELECT id FROM estado WHERE uf = 'PR'));
-- INSERT INTO cidade(id, codigo, nome, estado_id) VALUES (nextval('cidade_id_seq'), 6308, 'Maringá', (SELECT id FROM estado WHERE uf = 'PR'));
-- 
-- INSERT INTO cidade(id, codigo, nome, estado_id) VALUES (nextval('cidade_id_seq'), 9434, 'Osvaldo Cruz', (SELECT id FROM estado WHERE uf = 'SP'));


-- Artistas
INSERT INTO artista (art_id, art_bibliografia, art_nome, art_popularidade) 
	VALUES (1, 'São foda bagarai!', 'Metallica', 5);
INSERT INTO artista (art_id, art_bibliografia, art_nome, art_popularidade) 
	VALUES (2, 'São fodinhas...', 'Enegenheiros do Hawaii', 4);

-- Album
INSERT INTO album (alb_id, alb_ano_lancamento, alb_nome, art_id) 
	VALUES (1, 1991, 'Black Album', 1);
INSERT INTO album (alb_id, alb_ano_lancamento, alb_nome, art_id) 
	VALUES (2, 2008, 'Death Magnetic', 1);

-- Genero
INSERT INTO genero (gen_id, gen_nome) 
	VALUES (1, 'Metal');
INSERT INTO genero (gen_id, gen_nome) 
	VALUES (2, 'Rock');
INSERT INTO genero (gen_id, gen_nome) 
	VALUES (3, 'Soul');
INSERT INTO genero (gen_id, gen_nome) 
	VALUES (4, 'Rap');
INSERT INTO genero (gen_id, gen_nome) 
	VALUES (5, 'Pop');
INSERT INTO genero (gen_id, gen_nome) 
	VALUES (6, 'Sertanojo');

-- Musica
INSERT INTO musica (mus_id, mus_duracao, mus_nome, mus_popularidade, alb_id, gen_id) 
	VALUES (1, '05:31:00', 'Enter Sandman', 5, 1, 1);
INSERT INTO musica (mus_id, mus_duracao, mus_nome, mus_popularidade, alb_id, gen_id) 
	VALUES (2, '06:28:00', 'Nothing Else Matters', 5, 1, 1);

SELECT setval ('album_id_seq', (SELECT max(alb_id) FROM album), true);
SELECT setval ('artista_id_seq', (SELECT max(art_id) FROM artista), true);
SELECT setval ('genero_id_seq', (SELECT max(gen_id) FROM genero), true);
SELECT setval ('musica_id_seq', (SELECT max(mus_id) FROM musica), true);