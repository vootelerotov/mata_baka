'''
Created on Mar 2, 2013

@author: Voss
'''

import numpy
from cvxopt import matrix
from cvxopt import solvers 
module = __import__("solver") 


def main():
    P = matrix([2,0,0,1], (2,2), tc = 'd')
    Q = matrix([0.0,0.0],(2,1), tc = 'd')
    G = matrix ([1.0,-1.0,1.0,1.0],(2,2), tc= 'd')
    h = matrix([0.1,0.0],(2,1), tc = 'd')
    
    solver = module.solver(P,Q,G,h)
    solution = solver.solve()
    print(solution)
    print(solution['x'])

if __name__ == '__main__':
    pass


main()