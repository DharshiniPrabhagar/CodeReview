using System;
using System.Collections.Generic;

namespace partyApp
{
class partymanager
{
public List<string> ppl=new List<string>();

public void addPerson(string p)
{
ppl.Add(p);
Console.WriteLine(p + " joined the party");
}
public void Rem(string x)
{
ppl.Remove(x);
Console.WriteLine(x+" left");
}
public void show()
{
Console.WriteLine("Party people:");
for(int i=0;i<ppl.Count;i++)
Console.WriteLine(ppl[i]);
}
public bool isthere(string n)
{
for(int i=0;i<ppl.Count;i++)
if(ppl[i]==n)
return true;
return false;
}
}
class Program{
static void Main(string[] args)
{
partymanager party=new partymanager();
party.addPerson("Alice");
party.addPerson("Bob");
party.show();
if(party.isthere("Alice"))
Console.WriteLine("Alice is at party");
party.Rem("Bob");
party.show();
}
}
}
