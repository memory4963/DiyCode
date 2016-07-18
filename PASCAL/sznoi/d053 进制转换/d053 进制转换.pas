USES MATH;
var
c,e,n,i:integer;
d:int64;
a:string;
begin
readln(a);
n:=0;
d:=0;
for i:= 4 downto 1 do
 begin
   begin
   case a[i] of
    '0':e:=0;
    '1':e:=1;
    '2':e:=2;
    '3':e:=3;
    '4':e:=4;
    '5':e:=5;
    '6':e:=6;
    '7':e:=7;
    '8':e:=8;
    '9':e:=9;
    'A','a':e:=10;
    'B','b':e:=11;
    'C','c':e:=12;
    'D','d':e:=13;
    'E','e':e:=14;
    'F','f':e:=15;
    end;
    end;
  d:=d+trunc(e*power(16,n));
  n:=n+1;
 end;
writeln(d);
end.
