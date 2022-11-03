create or replace procedure ALL_SEATS_AVAILABLE(out all_seats_available )
language plpgsql
as $$
begin
select * from seats where status = 'available';
end
$$;