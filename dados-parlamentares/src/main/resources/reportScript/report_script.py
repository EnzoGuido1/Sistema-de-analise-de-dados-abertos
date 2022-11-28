import numpy as np
import sys
import matplotlib.pyplot as plt

def bar_graph(arg1, arg2, arg3, arg4, arg5, arg6):
    plt.bar(arg1.split(' '), [int(a) for a in arg2.split(' ')], color = 'blue')
    plt.xlabel(arg4)
    plt.ylabel(arg5)
    plt.title(arg3)
    plt.savefig(arg6)
    plt.cla()
    plt.clf()
    return arg1, arg2, arg3, arg4, arg5, arg6

def pie_chart(arg1, arg2, arg3):
    values = arg1.split(' ')
    plt.pie(values)
    plt.title(arg2)
    plt.savefig(arg3)
    plt.cla()
    plt.clf()
    return arg1, arg2, arg3

arg1 = sys.argv[1]
arg2 = sys.argv[2]
arg3 = sys.argv[3]
arg4 = sys.argv[4]
arg5 = sys.argv[5]
arg6 = sys.argv[6]
arg7 = sys.argv[7]
arg8 = sys.argv[8]
arg9 = sys.argv[9]
arg10 = sys.argv[10]
arg11 = sys.argv[11]
arg12 = sys.argv[12]
arg13 = sys.argv[13]
arg14 = sys.argv[14]
arg15 = sys.argv[15]
arg16 = sys.argv[16]
arg17 = sys.argv[17]
arg18 = sys.argv[18]
bar_graph(arg1, arg2, arg3, arg4, arg5, arg6)
bar_graph(arg7, arg8, arg9, arg10, arg11, arg12)
pie_chart(arg13, arg14, arg15)
pie_chart(arg16, arg17, arg18)