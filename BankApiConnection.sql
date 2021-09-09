SELECT
    * FROM HR.up_subscription;
    
    
    
CREATE SEQUENCE client_seq
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;
 
 
CREATE OR REPLACE TRIGGER clients_on_insert
  BEFORE INSERT ON HR.up_subscription
  FOR EACH ROW
BEGIN
:new.subscription_id:=client_seq.nextval; 
END;


drop TABLE HR.up_subscription;
drop SEQUENCE client_seq;
drop TRIGGER clients_on_insert;

