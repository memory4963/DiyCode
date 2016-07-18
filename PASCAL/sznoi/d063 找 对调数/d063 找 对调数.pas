var
a,b,c,d,n,e:integer;
begin
readln(n);
a:=n div 10;
b:=n mod 10;
e:=0;
if b=0 then 
        writeln('No!')
else
        for c:= 1 to 9 do
            for d:=1 to 9 do
                if (n+ c*10+d=b*10+a+d*10+c) and (n<>(d*10+c)) then
                begin
                        writeln(c,d);
                        inc(e);
                end;
if e=0 then writeln('No!');
end.