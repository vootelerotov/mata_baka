# -*- coding: utf-8 -*- 
'''
Created on Mar 2, 2013

@author: Vootele Rõtov
'''



import numpy
from cvxopt import matrix
from cvxopt import solvers 

class solver(object):
    '''
    classdocs
    '''
    
    objective_quadric_matrix = None
    objective_linear_vector = None
    constraint_matrix = None
    constraint_vector = None
    
    
    
    


    def __init__(self,objective_quadric,objective_linear,constraint_matrix,constraint_vector):
        self.objective_quadric_matrix=objective_quadric
        self.objective_linear_vector = objective_linear
        self.constraint_matrix = constraint_matrix
        self.constraint_vector = constraint_vector 

    def solve(self,solver_type=None):
        if solver_type == None:
            solution = solvers.qp(self.objective_quadric_matrix,self.objective_linear_vector,self.constraint_matrix,self.constraint_vector)
            return solution