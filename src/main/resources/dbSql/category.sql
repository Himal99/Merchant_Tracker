BEGIN
DECLARE
    @count smallint
    SET @count = (Select count(*) from register_category)
        BEGIN
            if(@count < 1)
            insert into register_category(category_name,status) values ('Food',0)
            insert into register_category(category_name,status) values ('Beverage',0)
            insert into register_category(category_name,status) values ('Travel',0)
            insert into register_category(category_name,status) values ('Stationery',0)
            insert into register_category(category_name,status) values ('Rent',0)
            insert into register_category(category_name,status) values ('Education',0)
            insert into register_category(category_name,status) values ('Furnishing',0)
        END
END;
