var
a:integer;
b:string;
begin
readln(a);
case a of
 1:b:='Tue';
 2:b:='Wed';
 3:b:='Thu';
 4:b:='Fri';
 5:b:='Sat';
 6:b:='Sun';
 0:b:='Mon';
end;
writeln(b);
end.
