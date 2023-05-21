CREATE TABLE park_ouvrage(
   id         VARCHAR(13) NOT NULL PRIMARY KEY
  ,nom        VARCHAR(23) NOT NULL
  ,adresse    VARCHAR(34) NOT NULL
  ,gratuit    VARCHAR(5) NOT NULL
  ,nb_places  INTEGER  NOT NULL
  ,nb_pmr     INTEGER 
  ,nb_velo    INTEGER 
  ,nb_2_rm    INTEGER 
  ,hauteur_ma INTEGER 
  ,Xlong      NUMERIC(17,15) NOT NULL
  ,Ylat       NUMERIC(18,15) NOT NULL
  ,type_ouvra VARCHAR(17)
  ,typo_fonct VARCHAR(12)
  ,nbre_niv   INTEGER  NOT NULL
  ,places_pub INTEGER 
  ,places_res INTEGER 
);
INSERT INTO park_ouvrage(id,nom,adresse,gratuit,nb_places,nb_pmr,nb_velo,nb_2_rm,hauteur_ma,Xlong,Ylat,type_ouvra,typo_fonct,nbre_niv,places_pub,places_res) VALUES ('34172_ANTIGO','Antigone','boulevard d''Antigone','false',248,6,0,0,185,3.888818930000000,43.608716059999999,'ouvrage','Centre-ville',2,242,0);
INSERT INTO park_ouvrage(id,nom,adresse,gratuit,nb_places,nb_pmr,nb_velo,nb_2_rm,hauteur_ma,Xlong,Ylat,type_ouvra,typo_fonct,nbre_niv,places_pub,places_res) VALUES ('34172_ARCTRI','Arc de Triomphe','rue Foch','false',451,10,0,0,190,3.873200750000000,43.611002669999998,'ouvrage','Centre-ville',5,438,0);
INSERT INTO park_ouvrage(id,nom,adresse,gratuit,nb_places,nb_pmr,nb_velo,nb_2_rm,hauteur_ma,Xlong,Ylat,type_ouvra,typo_fonct,nbre_niv,places_pub,places_res) VALUES ('34172_ARCEAU','Arceaux','place Max Rouquette','false',208,5,0,0,NULL,3.867490670000000,43.611716469999998,'enclos_en_surface','Centre-ville',1,203,0);
INSERT INTO park_ouvrage(id,nom,adresse,gratuit,nb_places,nb_pmr,nb_velo,nb_2_rm,hauteur_ma,Xlong,Ylat,type_ouvra,typo_fonct,nbre_niv,places_pub,places_res) VALUES ('34057_DEGAUL','Charles de Gaulle','rue du Prado','false',50,0,0,0,190,3.897762100000000,43.628542119999999,'enclos_en_surface','Proximité',0,0,0);
INSERT INTO park_ouvrage(id,nom,adresse,gratuit,nb_places,nb_pmr,nb_velo,nb_2_rm,hauteur_ma,Xlong,Ylat,type_ouvra,typo_fonct,nbre_niv,places_pub,places_res) VALUES ('34172_CIRCE','Circé Odysseum','rue Georges Melies','false',1200,0,0,0,190,3.917849500000000,43.604953770000002,'ouvrage','Parc relais',0,0,0);
INSERT INTO park_ouvrage(id,nom,adresse,gratuit,nb_places,nb_pmr,nb_velo,nb_2_rm,hauteur_ma,Xlong,Ylat,type_ouvra,typo_fonct,nbre_niv,places_pub,places_res) VALUES ('34172_COMEDI','Comédie','place de la Comedie','false',824,17,0,9,185,3.879761960000000,43.608560920000002,'ouvrage','Centre-ville',4,787,20);
INSERT INTO park_ouvrage(id,nom,adresse,gratuit,nb_places,nb_pmr,nb_velo,nb_2_rm,hauteur_ma,Xlong,Ylat,type_ouvra,typo_fonct,nbre_niv,places_pub,places_res) VALUES ('34172_CORUM','Corum','rue du Faubourg de Nimes','false',483,10,0,0,185,3.882257730000000,43.613888209999999,'ouvrage','Centre-ville',3,473,0);
INSERT INTO park_ouvrage(id,nom,adresse,gratuit,nb_places,nb_pmr,nb_velo,nb_2_rm,hauteur_ma,Xlong,Ylat,type_ouvra,typo_fonct,nbre_niv,places_pub,places_res) VALUES ('34172_EUROME','Euromédecine','rue de Chambert','false',350,0,0,0,200,3.827723650000000,43.638953590000000,'enclos_en_surface','Parc relais',0,0,0);
INSERT INTO park_ouvrage(id,nom,adresse,gratuit,nb_places,nb_pmr,nb_velo,nb_2_rm,hauteur_ma,Xlong,Ylat,type_ouvra,typo_fonct,nbre_niv,places_pub,places_res) VALUES ('34172_EUROPA','Europa','Rue Poséidon','false',600,10,0,0,250,3.892530740000000,43.607849710000004,'ouvrage','Centre-ville',2,590,0);
INSERT INTO park_ouvrage(id,nom,adresse,gratuit,nb_places,nb_pmr,nb_velo,nb_2_rm,hauteur_ma,Xlong,Ylat,type_ouvra,typo_fonct,nbre_niv,places_pub,places_res) VALUES ('34172_FOCHPR','Foch Préfecture','Place des Martyrs de la Resistance','false',685,9,0,0,190,3.876570840000000,43.610749120000001,'ouvrage','Centre-ville',5,385,291);
INSERT INTO park_ouvrage(id,nom,adresse,gratuit,nb_places,nb_pmr,nb_velo,nb_2_rm,hauteur_ma,Xlong,Ylat,type_ouvra,typo_fonct,nbre_niv,places_pub,places_res) VALUES ('34172_GAMBET','Gambetta','cours Gambetta','false',482,10,0,2,190,3.871374360000000,43.606951379999998,'ouvrage','Centre-ville',1,472,0);
INSERT INTO park_ouvrage(id,nom,adresse,gratuit,nb_places,nb_pmr,nb_velo,nb_2_rm,hauteur_ma,Xlong,Ylat,type_ouvra,typo_fonct,nbre_niv,places_pub,places_res) VALUES ('34172_LORCA','Garcia Lorca','avenue de Palavas','false',400,0,0,0,200,3.890715800000000,43.590985089999997,'ouvrage','Parc relais',0,0,0);
INSERT INTO park_ouvrage(id,nom,adresse,gratuit,nb_places,nb_pmr,nb_velo,nb_2_rm,hauteur_ma,Xlong,Ylat,type_ouvra,typo_fonct,nbre_niv,places_pub,places_res) VALUES ('34172_MOSSON','Mosson','route de Lodève','false',450,0,0,0,210,3.819665540000000,43.616237159999997,'enclos_en_surface','Parc relais',0,0,0);
INSERT INTO park_ouvrage(id,nom,adresse,gratuit,nb_places,nb_pmr,nb_velo,nb_2_rm,hauteur_ma,Xlong,Ylat,type_ouvra,typo_fonct,nbre_niv,places_pub,places_res) VALUES ('34057_SABLAS','Notre Dame de Sablassou','chemin du Pech Saint Peyre','false',350,0,0,0,200,3.922295360000000,43.634191940000001,'enclos_en_surface','Proximité',0,0,0);
INSERT INTO park_ouvrage(id,nom,adresse,gratuit,nb_places,nb_pmr,nb_velo,nb_2_rm,hauteur_ma,Xlong,Ylat,type_ouvra,typo_fonct,nbre_niv,places_pub,places_res) VALUES ('34172_OCCITA','Occitanie','avenue du Doyen Giraud','false',620,0,0,0,200,3.848597960000000,43.634562320000001,'ouvrage','Parc relais',0,0,0);
INSERT INTO park_ouvrage(id,nom,adresse,gratuit,nb_places,nb_pmr,nb_velo,nb_2_rm,hauteur_ma,Xlong,Ylat,type_ouvra,typo_fonct,nbre_niv,places_pub,places_res) VALUES ('34172_PITOT','Pitot','rue du Carré du Roi','false',771,10,9,9,256,3.870191170000000,43.612244939999997,'ouvrage','Centre-ville',3,553,208);
INSERT INTO park_ouvrage(id,nom,adresse,gratuit,nb_places,nb_pmr,nb_velo,nb_2_rm,hauteur_ma,Xlong,Ylat,type_ouvra,typo_fonct,nbre_niv,places_pub,places_res) VALUES ('34172_POLYGO','Polygone','rue des Pertuisanes','false',1942,20,0,0,NULL,3.884765390000000,43.608370960000002,'ouvrage','Centre-ville',4,1922,0);
INSERT INTO park_ouvrage(id,nom,adresse,gratuit,nb_places,nb_pmr,nb_velo,nb_2_rm,hauteur_ma,Xlong,Ylat,type_ouvra,typo_fonct,nbre_niv,places_pub,places_res) VALUES ('34172_SABINE','Sabines','avenue du Colonel Pavelet','false',350,0,0,0,200,3.860224600000000,43.583832630000003,'enclos_en_surface','Parc relais',0,0,0);
INSERT INTO park_ouvrage(id,nom,adresse,gratuit,nb_places,nb_pmr,nb_velo,nb_2_rm,hauteur_ma,Xlong,Ylat,type_ouvra,typo_fonct,nbre_niv,places_pub,places_res) VALUES ('34172_SAINTRO','Saint Roch','rue du Grand Saint Jean','false',805,12,40,30,200,3.878550720000000,43.603291489999997,'ouvrage','Centre-ville',11,711,94);
INSERT INTO park_ouvrage(id,nom,adresse,gratuit,nb_places,nb_pmr,nb_velo,nb_2_rm,hauteur_ma,Xlong,Ylat,type_ouvra,typo_fonct,nbre_niv,places_pub,places_res) VALUES ('34270_LESEC','Saint-Jean-le-Sec','avenue de Libria','false',282,0,0,0,220,3.837931200000000,43.570822249999999,'enclos_en_surface','Parc relais',0,0,0);
INSERT INTO park_ouvrage(id,nom,adresse,gratuit,nb_places,nb_pmr,nb_velo,nb_2_rm,hauteur_ma,Xlong,Ylat,type_ouvra,typo_fonct,nbre_niv,places_pub,places_res) VALUES ('34172_TRIANG','Triangle','rue Foch','false',594,0,0,0,190,3.881844180000000,43.609233840000002,'ouvrage','Centre-ville',0,436,158);
INSERT INTO park_ouvrage(id,nom,adresse,gratuit,nb_places,nb_pmr,nb_velo,nb_2_rm,hauteur_ma,Xlong,Ylat,type_ouvra,typo_fonct,nbre_niv,places_pub,places_res) VALUES ('34057_VICCAR','Viccarello','rue de la Crouzette','false',64,NULL,NULL,NULL,190,3.89868,43.63245,NULL,NULL,1,NULL,NULL);
