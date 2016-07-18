var  
n,i:longint;   
begin  
readln(n);   
i:=2;   
while i<=n do 
begin  
        while n mod i=0 do 
        begin  
                write(i);   
                n:=n div i;   
                if n<>1 then write('*');   
        end;   
        inc(i);   
end;   
end.  
