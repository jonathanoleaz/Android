package com.example.myappsql.entities;


import java.io.Serializable;
import java.util.Date;

public class Evento implements Serializable {


        private Integer idEvento;

        private String nombreEvento;

        private Date inicio;

        private Date fin;

        private String observaciones;

        //private Collection<Asistente> asistenteCollection;

        public Evento() {
        }

        public Evento(Integer idEvento) {
            this.idEvento = idEvento;
        }

        public Evento(Integer idEvento, String nombreEvento, Date inicio, Date fin) {
            this.idEvento = idEvento;
            this.nombreEvento = nombreEvento;
            this.inicio = inicio;
            this.fin = fin;
        }

        public Integer getIdEvento() {
            return idEvento;
        }

        public void setIdEvento(Integer idEvento) {
            this.idEvento = idEvento;
        }

        public String getNombreEvento() {
            return nombreEvento;
        }

        public void setNombreEvento(String nombreEvento) {
            this.nombreEvento = nombreEvento;
        }

        public Date getInicio() {
            return inicio;
        }

        public void setInicio(Date inicio) {
            this.inicio = inicio;
        }

        public Date getFin() {
            return fin;
        }

        public void setFin(Date fin) {
            this.fin = fin;
        }

        public String getObservaciones() {
            return observaciones;
        }

        public void setObservaciones(String observaciones) {
            this.observaciones = observaciones;
        }

        //public Collection<Asistente> getAsistenteCollection() {
        //    return asistenteCollection;
        //}

        //public void setAsistenteCollection(Collection<Asistente> asistenteCollection) {
        //    this.asistenteCollection = asistenteCollection;
        //}

        @Override
        public int hashCode() {
            int hash = 0;
            hash += (idEvento != null ? idEvento.hashCode() : 0);
            return hash;
        }

        @Override
        public boolean equals(Object object) {
            // TODO: Warning - this method won't work in the case the id fields are not set
            if (!(object instanceof Evento)) {
                return false;
            }
            Evento other = (Evento) object;
            if ((this.idEvento == null && other.idEvento != null) || (this.idEvento != null && !this.idEvento.equals(other.idEvento))) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return nombreEvento;
            //return "dao.Evento[ idEvento=" + idEvento + " ]";
        }

    }
