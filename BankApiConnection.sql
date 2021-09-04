SELECT
    * FROM HR.up_subscription;
    
    
    
    CREATE SEQUENCE client_seq
 START WITH     1
 INCREMENT BY   1
 MINVALUE 1
 MAXVALUE 999999999999999999999999999;
 
    
    CREATE OR REPLACE TRIGGER clients_on_insert
  BEFORE UPDATE ON HR.up_subscription
  FOR EACH ROW
BEGIN
  if :new.subscription_id is null then
     SELECT client_seq.nextval
    INTO :new.subscription_id
    FROM dual;
  END IF;
END;


drop TABLE HR.up_subscription;
drop SEQUENCE client_seq;
drop TRIGGER clients_on_insert;

