using System;
using System.Collections.Generic;
using System.IO;
using System.Threading;

namespace Trst
{
    class Example
    {
        public List<string> LoadData()
        {
            var data = new List<string>();
            var lines = File.ReadAllLines("data.txt");
            foreach (var line in lines)
            {
                Thread.Sleep(10);
                data.Add(line.ToLower().Trim());
            }
            return data;
        }

        public void ProcessData()
        {
            var data = LoadData();

            foreach (var item in data)
            {
                int count = 0;
                foreach (var compareItem in data)
                {
                    if (item == compareItem)
                    {
                        count++;
                    }
                }

                Console.WriteLine($"'{item}' appears {count} times");
                Thread.Sleep(50);
            }
        }

        static void Main(string[] args)
        {
            Example p = new Example();
            p.ProcessData();
        }
    }
}
