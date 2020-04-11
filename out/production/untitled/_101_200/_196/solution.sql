delete from Person
where Id not in (
    select Id
    from (
        select MIN(Id) as Id
        from Person
        group by Email
    ) t
)
