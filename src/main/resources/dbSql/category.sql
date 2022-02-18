BEGIN
DECLARE
    @count smallint
    SET @count = (Select count(*) from register_category)
        BEGIN
            if(@count < 1)
            insert into register_category(category_name,status) values ('Food',0)
            insert into register_category(category_name,status) values ('Apple',0)
            insert into register_category(category_name,status) values ('Banana',0)
            insert into register_category(category_name,status) values ('Mango',0)
            insert into register_category(category_name,status) values ('Orange',0)
            insert into register_category(category_name,status) values ('Potato',0)
        END
END;
