INSERT INTO customer_status (name) VALUES ('NORMAL');
INSERT INTO customer_status (name) VALUES ('FAIL');

INSERT INTO service_status (name) VALUES ('NORMAL');
INSERT INTO service_status (name) VALUES ('FAIL');
INSERT INTO service_status (name) VALUES ('UNDER_MAINT');
INSERT INTO service_status (name) VALUES ('TO_REPLACE');

INSERT INTO hardware_status (name) VALUES ('NORMAL');
INSERT INTO hardware_status (name) VALUES ('FAIL');
INSERT INTO hardware_status (name) VALUES ('UNDER_MAINT');
INSERT INTO hardware_status (name) VALUES ('TO_REPLACE');

INSERT INTO address (full_address) VALUES ('ул ломоносова д 23');
INSERT INTO address (full_address) VALUES ('ул северная  д 30');
INSERT INTO address (full_address) VALUES ('ул рождественская д 1');
INSERT INTO address (full_address) VALUES ('ул рождественская д 2');
INSERT INTO address (full_address) VALUES ('ул рождественская д 3');
INSERT INTO address (full_address) VALUES ('ул рождественская д 4');
INSERT INTO address (full_address) VALUES ('ул рождественская д 5');
INSERT INTO address (full_address) VALUES ('ул рождественская д 6');
INSERT INTO address (full_address) VALUES ('ул выборгская д 1');
INSERT INTO address (full_address) VALUES ('ул выборгская д 2');
INSERT INTO address (full_address) VALUES ('ул выборгская д 3');
INSERT INTO address (full_address) VALUES ('ул выборгская д 4');
INSERT INTO address (full_address) VALUES ('ул выборгская д 5');
INSERT INTO address (full_address) VALUES ('ул выборгская д 6');
INSERT INTO address (full_address) VALUES ('ул гужевая д 1');
INSERT INTO address (full_address) VALUES ('ул гужевая д 2');
INSERT INTO address (full_address) VALUES ('ул гужевая д 3');
INSERT INTO address (full_address) VALUES ('ул гужевая д 4');
INSERT INTO address (full_address) VALUES ('ул гужевая д 5');
INSERT INTO address (full_address) VALUES ('ул гужевая д 6');
INSERT INTO address (full_address) VALUES ('ул минина д 1');
INSERT INTO address (full_address) VALUES ('ул минина д 2');
INSERT INTO address (full_address) VALUES ('ул минина д 3');

INSERT INTO customer (first_name,last_name,phone_number,customer_status_id) VALUES ('Alex','McGregor','79999999999',2);
INSERT INTO customer (first_name,last_name,phone_number,customer_status_id) VALUES ('Niko','Fury','79333333333',1);
INSERT INTO customer (first_name,last_name,phone_number,customer_status_id) VALUES ('Mike','Miklo','79555555555',1);
INSERT INTO customer (first_name,last_name,phone_number,customer_status_id) VALUES ('Zina','Sergeeva','79222222222',2);
INSERT INTO customer (first_name,last_name,phone_number,customer_status_id) VALUES ('Alla','Brovchenko','79332323232',1);
INSERT INTO customer (first_name,last_name,phone_number,customer_status_id) VALUES ('Alla','Brovchenko','79332323232',1);
INSERT INTO customer (first_name,last_name,phone_number,customer_status_id) VALUES ('Rodrogo','Leiaa','79332344512',2);
INSERT INTO customer (first_name,last_name,phone_number,customer_status_id) VALUES ('leazzi','Loiir','79332323231',1);
INSERT INTO customer (first_name,last_name,phone_number,customer_status_id) VALUES ('Reofo','Loiiw','79332321232',2);
INSERT INTO customer (first_name,last_name,phone_number,customer_status_id) VALUES ('Allaaa','Brovchenkfo','70332323232',1);


INSERT INTO service (name,customer_id,service_status_id) VALUES ('Internet',1,1);
INSERT INTO service (name,customer_id,service_status_id) VALUES ('TV',1,2);
INSERT INTO service (name,customer_id,service_status_id) VALUES ('Internet',2,1);
INSERT INTO service (name,customer_id,service_status_id) VALUES ('TV',2,1);
INSERT INTO service (name,customer_id,service_status_id) VALUES ('Internet',3,1);
INSERT INTO service (name,customer_id,service_status_id) VALUES ('TV',3,1);
INSERT INTO service (name,customer_id,service_status_id) VALUES ('Internet',4,2);
INSERT INTO service (name,customer_id,service_status_id) VALUES ('TV',4,1);

INSERT INTO hardware (name,service_id,serial,hardware_status_id,address_id) VALUES ('ARRIS - SURFboard Dual-Band AC2350 with 32 x 8 DOCSIS 3.0',1,'RN1231231231',1,1);
INSERT INTO hardware (name,service_id,serial,hardware_status_id,address_id) VALUES ('ARRIS - SURFboard Dual-Band AC2350 with 32 x 8 DOCSIS 3.0',1,'TZ23423423424',1,2);
INSERT INTO hardware (name,service_id,serial,hardware_status_id,address_id) VALUES ('CISCO 800 Series Industrial Integrated Services Router',1,'BMBM23423423',1,3);
INSERT INTO hardware (name,service_id,serial,hardware_status_id,address_id) VALUES ('Linksys - AC2200 Tri-Band Mesh WiFi 5 Router',NULL,'MM6699634343',1,NULL);
INSERT INTO hardware (name,service_id,serial,hardware_status_id,address_id) VALUES ('CISCO 1000 Series Connected Grid Routers',2,'BMBM2ETET444',2,5);
INSERT INTO hardware (name,service_id,serial,hardware_status_id,address_id) VALUES ('CISCO 4000 Series ISRM',2,'CVB45345325324',1,5);
INSERT INTO hardware (name,service_id,serial,hardware_status_id,address_id) VALUES ('Cisco SPA122 Small Business ATA with Router',3,'FDBF452345234',1,8);
INSERT INTO hardware (name,service_id,serial,hardware_status_id,address_id) VALUES ('Cisco SPA122 Small Business ATA with Router',3,'GBGB234523452',1,8);
INSERT INTO hardware (name,service_id,serial,hardware_status_id,address_id) VALUES ('Cisco 2000 Series Grid',4,'FDF23452345324',1,9);
INSERT INTO hardware (name,service_id,serial,hardware_status_id,address_id) VALUES ('Juniper MX10003',4,'GBD43252234444',1,10);
INSERT INTO hardware (name,service_id,serial,hardware_status_id,address_id) VALUES ('Juniper MX240',5,'JMJM4545645645',1,10);
INSERT INTO hardware (name,service_id,serial,hardware_status_id,address_id) VALUES ('Juniper MX480',5,'LL56756756753',1,12);
INSERT INTO hardware (name,service_id,serial,hardware_status_id,address_id) VALUES ('Juniper MX960',6,'HYHY45635463356',1,13);
INSERT INTO hardware (name,service_id,serial,hardware_status_id,address_id) VALUES ('Juniper MX2008',6,'HYH34563322222',1,16);
INSERT INTO hardware (name,service_id,serial,hardware_status_id,address_id) VALUES ('Juniper MX2010',7,'PLD34535345222',1,16);
INSERT INTO hardware (name,service_id,serial,hardware_status_id,address_id) VALUES ('Juniper MX2020',7,'VMVM34534534',2,16);
INSERT INTO hardware (name,service_id,serial,hardware_status_id,address_id) VALUES ('HPE FlexNetwork MSR93x Router Series',8,'F1253334678655',1,16);
INSERT INTO hardware (name,service_id,serial,hardware_status_id,address_id) VALUES ('HPE FlexNetwork HSR6600 Router Series',8,'F34534522254345',1,23);
INSERT INTO hardware (name,service_id,serial,hardware_status_id,address_id) VALUES ('CISCO 4000 Series ISRM',NULL,'TY546456456',1,NULL);
INSERT INTO hardware (name,service_id,serial,hardware_status_id,address_id) VALUES ('CISCO 4000 Series ISRM',NULL,'Z15TTERTWTERT',1,NULL);
