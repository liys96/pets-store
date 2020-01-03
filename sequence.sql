prompt PL/SQL Developer Export User Objects for user SCOTT@ORCL
prompt Created by Administrator on 2019年5月7日
set define off
spool sequence序列.log

prompt
prompt Creating sequence SEQ_APPRAISE
prompt ==============================
prompt
create sequence SCOTT.SEQ_APPRAISE
minvalue 1
maxvalue 9999999999999999999999999999
start with 81
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_CATEGORY
prompt ==============================
prompt
create sequence SCOTT.SEQ_CATEGORY
minvalue 1
maxvalue 9999999999999999999999999999
start with 21
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_COMMODITY
prompt ===============================
prompt
create sequence SCOTT.SEQ_COMMODITY
minvalue 1
maxvalue 9999999999999999999999999999
start with 101
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_COMPOSITION
prompt =================================
prompt
create sequence SCOTT.SEQ_COMPOSITION
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_CUSTOMER
prompt ==============================
prompt
create sequence SCOTT.SEQ_CUSTOMER
minvalue 1
maxvalue 9999999999999999999999999999
start with 81
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_INVENTORY
prompt ===============================
prompt
create sequence SCOTT.SEQ_INVENTORY
minvalue 1
maxvalue 9999999999999999999999999999
start with 81
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_MARQUE
prompt ============================
prompt
create sequence SCOTT.SEQ_MARQUE
minvalue 1
maxvalue 9999999999999999999999999999
start with 141
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_ORDER
prompt ===========================
prompt
create sequence SCOTT.SEQ_ORDER
minvalue 1
maxvalue 9999999999999999999999999999
start with 161
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_ORDERCOMMODITY
prompt ====================================
prompt
create sequence SCOTT.SEQ_ORDERCOMMODITY
minvalue 1
maxvalue 9999999999999999999999999999
start with 21
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_SHOPCART
prompt ==============================
prompt
create sequence SCOTT.SEQ_SHOPCART
minvalue 1
maxvalue 9999999999999999999999999999
start with 161
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_TYPES
prompt ===========================
prompt
create sequence SCOTT.SEQ_TYPES
minvalue 1
maxvalue 9999999999999999999999999999
start with 21
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_USER
prompt ==========================
prompt
create sequence SCOTT.SEQ_USER
minvalue 1
maxvalue 9999999999999999999999999999
start with 101
increment by 1
cache 20;


prompt Done
spool off
set define on
