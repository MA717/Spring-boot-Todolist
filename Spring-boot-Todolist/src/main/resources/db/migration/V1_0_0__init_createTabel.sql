CREATE TABLE  tbl_task (

                           uuid Varchar(36)  NOT Null,
                           completed bit(1) ,
                           message varchar(100) NOT Null,
                           Primary key(uuid)
);
