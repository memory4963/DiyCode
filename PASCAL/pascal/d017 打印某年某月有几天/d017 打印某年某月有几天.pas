var
a,b,c,d:integer;
begin
readln(a,b);
case (a mod 4) of
 0:
  begin
   case b of
    1,3,5,7,8,10,12:c:=31;
    4,6,9,11:c:=30;
    2:c:=29;
   end;
  end;
 1,2,3,4:
  begin
   case b of
    1,3,5,7,8,10,12:c:=31;
    4,6,9,11:c:=30;
    2:c:=28;
   end;
  end;
end;
writeln(c);
end.


