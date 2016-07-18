var
a,b,c:array[1..201] of 0..9;
n:string;
lena,lenb,lenc,i,x:integer;
begin
read(n);
lena:=length(n);
for i:=1 to lena do a[lena-i+1]:=ord(n)-ord('0');{加数放入a数组}
readln(n);
lenb:=length(n);
for i:=1 to lenb do b[lenb-i+1]:=ord(n)-ord('0');{被加数放入b数组}
i:=1;
while (i<=lena) or(i<=lenb) do
begin
x := a + b + x div 10; {两数相加，然后加前次进位}
c := x mod 10; {保存第i位的值}
i := i + 1
end;
if x>=10 {处理最高进位}
then
begin
lenc:=i;
c:=1
end
else lenc:=i-1;
for i:=lenc downto 1 do write(c);
writeln； {输出结果}
end.
